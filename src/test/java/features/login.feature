@login
Feature: Login

  #@openUrl
  #Scenario:Login Invalid
   # Given Open url

  @loginInvalid
  Scenario Outline: Login Invalid
    Given Open url
    When login with credentials "<user>" "<password>"
    Then valid message "<msj>" "<login_ok>"
    Examples:
      | user | password     | msj                 | login_ok | comments                |
      | user | pass_invalid | Invalid credentials | false    | Test - password invalid |


  @login @loginValid
  Scenario Outline: Login Valid
    #Given Open url
    Then login with credentials "<user>" "<password>"
    Then valid message "<msg_login>" "<login_ok>"
    Examples:
      | user | password | msg_login | login_ok | comments        |
      | user | pass     | Dashboard | false        | Test - login ok |









