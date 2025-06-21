Feature: Add Products to Shopping Cart

  Background:
    Given User is logged into the application


  Scenario: User is able to add products into the shopping cart
    Given User clicks on the Product sort container link
    And User clicks on the Add to cart button for Sauce Labs Bike Light
    When User clicks the shoppingcart link
    Then Sauce Labs Bike Light is added to the shopping cart
    And Checkout And Enter the details to finish