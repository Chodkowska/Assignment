Feature: adding new address to user account

  Scenario Outline: user can add new address to their account

    Given open https://mystore-testlab.coderslab.pl/
    When sign in
    And open addresses page
    And fill in alias <Alias>
    And fill in address <Address>
    And fill in zip/postal code <ZipPostalCode>
    And fill in city <City>
    And fill in country <Country>
    And fill in phone <Phone>
    And save new address
    Then add new address
    And quit browsing

    Examples:

      | Alias   | Company       | VAT number | Address           | Address Complement | ZipPostalCode | City   | Country        | Phone   |
      | qwerty  | Soft          | 1234566    | Addre Street 1/23 |                    | 12-345        | Adcity | United Kingdom | 1234561 |