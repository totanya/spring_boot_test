*** Settings ***
Documentation  My first Robot test
Resource     helper_keywords.robot

*** Test Cases ***
Test_POST
    Given User can access the API
    When User fill the field id with "1"
    And User fill the field "name" with "Generic Name"
    And User fill the field phone with "999999999"
    And User fill the field "email" with "genericname@company.com"
    And User fill the field "address" with "Generic Street 42 Earth"
    And User fill the field "country" with "Navarro"
    And User fill the field "department" with "T21R"
    And User send this data to API (CREATE)
    Then API should return Ok with a success message

Scenario 2
    Given User can access the API
    When User fill the field id with "2"
    And User fill the field "name" with "Kuill"
    And User fill the field "phone" with "99999999999999"
    And User fill the field "email" with "genericname@company.com"
    And User fill the field "address" with "Generic Street 42 Hoth"
    And User fill the field "country" with "Arvala"
    And User fill the field "department" with "T21R"
    And User send this data to API (CREATE)
    Then API should return error with a message

Scenario 3
    Given User can access the API
    When User fill the field id with "1"
    And User fill the field "name" with "Generic Name"
    And User fill the field "phone" with "222222222"
    And User fill the field "email" with "genericname@company.com"
    And User fill the field "address" with "Generic Street 42 Earth"
    And User fill the field "country" with "Navarro"
    And User fill the field "department" with "T21R"
    And User send this data to API (UPDATE)
    Then API should return Ok with a success message

Scenario 4
    Given User can access the API
    When User wants to delete the account with id: "1"
    And User send this data to API (DELETE)
    Then API should return no content with a success message

