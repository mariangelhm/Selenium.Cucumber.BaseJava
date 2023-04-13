@createEmployee
Feature: create employee

  @createEmployee
  Scenario Outline: create employee
    Given Open url
    Then login with credentials "<user>" "<pass>"
    Then valid message "<msg_login>" "<login_ok>"
    When Go to module pim "<msj>"
    When fill out employee creation form
    When Add emergency contacts
    Examples:
      | msj                  | user | msg_login | pass | login_ok | comments                                                     |
      | Employee Information | user | Dashboard | pass | true     | Go to the PIM Module and validate the message after clicking |









