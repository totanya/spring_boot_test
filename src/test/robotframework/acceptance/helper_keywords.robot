*** Settings ***
Documentation  My first Robot test
Library     RequestsLibrary
Library     Collections
Library     String

*** Variables ***
${base_url}     http://localhost:8080/api/v1
&{body}
${response_status_code}     0

*** Keywords ***
User can access the API
    ${body}=    create dictionary
    FOR    ${key}    IN    @{body.keys()}
        remove from dictionary  ${mydict["${key}"]}
    END

User fill the field ${field_name} with ${field_value}
    ${key}=        strip string  ${field_name}     both    "
    ${str_value}=  strip string  ${field_value}   both    "
    ${int_value}=  run keyword if  "${key}" == "id"
    ...  convert to integer  ${str_value}
    ${value}=  set variable if  "${key}" == "id"
    ...  ${int_value}
    ...  ${str_value}
    set to dictionary   ${body}     ${key}   ${value}

User send this data to API (CREATE)
    create session      mysession   ${base_url}
    ${headers}=  create dictionary   Content-Type=application/json
    ${response}=    POST On Session  mysession  /accounts  json=${body}    headers=${headers}  expected_status=any
    set global variable  ${response_status_code}  ${response.status_code}

User send this data to API (UPDATE)
    create session      mysession   ${base_url}
    ${headers}=  create dictionary   Content-Type=application/json
    ${response}=  PUT On Session  mysession  /accounts/${body["id"]}  json=${body}    headers=${headers}  expected_status=any
    set global variable  ${response_status_code}  ${response.status_code}

User send this data to API (DELETE)
    create session      mysession   ${base_url}
    ${response}=    Delete On Session  mysession  /accounts/${body["id"]}  expected_status=any
    set global variable  ${response_status_code}  ${response.status_code}

API should return ${status} with a ${message}
    run keyword if  "${status}" == "Ok"
    ...  run keyword unless  ${200} <= ${response_status_code} <= ${204}  Fail
    run keyword if  "${status}" == "Error"
    ...  run keyword unless  ${response_status_code} > ${400}  Fail
    run keyword if  "${status}" == "no content"
    ...  should be equal  ${response_status_code}  ${204}

User wants to delete the account with id: ${str_id}
    ${str_value}=  strip string  ${str_id}   both    "
    set to dictionary   ${body}     id   ${str_value}
