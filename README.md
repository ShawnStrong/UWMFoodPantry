# UWMFoodPantry

Three ways to enter data:
1. Add data: category, size, weight
  Kinds of categories: determined dynamically by the user
  Size: (example: small, medium, large) 
  Weight: Associated with each size
2. Outgoing donations: The user is shown the current amount in the inventory. They may update the amounts which directly correlates to the database table values. This amount may only be less than the current amount, and the difference between the old and new amounts are recorded in the history log.
3. Incoming donations: The user chooses a (user-predefined) category, size, and AMOUNT. The amount is the quantity of the category/size being inputted. 

There are four pages for the UI:
1. Category maintenance: On this page, the user can define new categories with corresponding sizes and weights. They can also view all of the current categories and their values.
2. Outgoing donations: The user records the current inventory in a table.
3. Incoming donations: The user records any added amounts in a table that displays all the categories, sizes, and weights.
4. Reports: There are multiple kinds of reports:
  1. Current inventory
  2. Outgoing data
  3. Outgoing/Incoming data
  The user will be able to print their inventory out. They can also print a donation log, which is the history of the inventory.

Database tables:
  category_table
    category_id     int(5)      auto_increment
    name            tinytext
    size            tinytext
    weight          int(7)
  donation_table
    outgoing_id     int(5)      auto_increment
    donation_type   int(1)
    name            tinytext
    size            tinytext
    weight          int(7)
    amount          int(7)
    username        tinytext
    date            timestamp   CURRENT_TIMESTAMP 
  user_table
    user_id         int(5)      auto_increment
    username        tinytext
    password        tinytext
