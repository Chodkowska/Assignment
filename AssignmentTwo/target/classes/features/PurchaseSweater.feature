Feature: Online shop purchase

  Scenario: User can purchase an item of specific size and select the right payment method

    Given user is logged in
    When navigate to clothes page
    And select product
    And select size
    And select quantity
    And add product to cart
    And proceed to checkout
    And confirm address
    And select delivery method
    And select payment method
    Then take screenshot
    And quit browsing