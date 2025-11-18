Feature: amazon ebook kindle application demo

  Scenario: Login should be success
    Given user should navigate to the amazon kindle ebook store
    And user clicks on the sign in link
    And user enters username as "<email>"
    And user enters password as "<password>"
    When user clicks the login button
    #Then login should be success
    When user searches for "<bookName>"
    And user clicks on the first book result
    And user adds the book to the cart
    Then the book "<bookName>" should be added successfully to the cart
Examples:

| email                           | password       | bookName               |
| godwinjeraldwilliam@gmail.com   | Godwinjw@2003  | Dopamine Detox         |
| godwinjeraldwilliam@gmail.com   | Godwinjw@2003  | fairy tales            |

