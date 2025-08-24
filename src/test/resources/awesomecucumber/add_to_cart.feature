Feature: Add to Cart Feature

  @smoke
  Scenario: Add products in cart on store page

  Given I am on the Store Page
  When I add a Blue Shoes to the cart
  Then I should see Blue Shoes in the cart

#  Scenario Outline: Add products in cart on store page -examples
#
#    Given I am on the Store Page
#    When I add a "<product_name>" to the cart
#    Then I should see "<product_name>" in the cart
#    Examples:
#    | product_name |
#    | Anchor Bracelet |
#    |Black Over-the-shoulder Handbag |