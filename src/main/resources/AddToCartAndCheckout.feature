@UIPlaceOrderScenario
  Feature: Add products in the cart and place the order
    Scenario Outline: User should be able to place an order by adding products in the cart
      Given user is ready with required details like "<userName>", "<password>"
      When user is able to add couple of products "<countOfProducts>" in the cart and checkout by providing details like "<firstName>","<lastName>" and "<postalCode>"
      Then verify that order is placed successfully with message "<message>"
      Examples:
      |userName|password|countOfProducts|firstName|lastName|postalCode|message|
      | standard_user       |   secret_sauce     |   2            |yogesh|kolhe|1700|  Thank you for your order!     |
