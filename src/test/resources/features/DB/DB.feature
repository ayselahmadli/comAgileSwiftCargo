Feature:DB_Testing


  @DB_US01
  Scenario: Verify that the number of users with gateway = 2 in the accounts table in the database is 33.

    * User sets the database connection
    * prepare query for accounts table
    * verify the number of users is 33
    * Database connection is closed

  @DB_US02
  Scenario: Verify the most viewed blog name in the blogs table via the database.

    * User sets the database connection
    * prepare query for blogs table
    * verify most viewed blog name
    * Database connection is closed

  @DB_US03
  Scenario: Verify that the data with log_name: User in the activity_log table via the database is more
            than the data with log_name: Upload.

    * User sets the database connection
    * prepare query for activity_log table
    * verify that the data in log_name: User is more than the data in log_name: Upload.
    * Database connection is closed

  @DB_US04
  Scenario: Verify the creation dates of the 5 most recently updated records in the bank transactions table
            via the database, sorting from oldest to newest.

    * User sets the database connection
    * prepare query for bank_transactions table
    * verify the creation dates of the 5 most recently updated records in the bank transactions table by ordering them from oldest to newest
    * Database connection is closed

  @DB_US05
  Scenario: List and verify the amount information of the data created between '2023-08-23 11:30:34' and '2023-10-01 20:44:08'
            from the data in the bank_transactions table in the database, in order from smallest to largest.

    * User sets the database connection
    * prepare query for bank_transactions table
    * list and verify the amount information of the data created between '2023-08-23 11:30:34' and '2023-10-01 20:44:08' in ascending order
    * Database connection is closed

  @DB_US06
  Scenario: List and verify how many different delivery drivers uniquely transported each parcel from the parcels whose
            parcel_id number is given in the courier_statements table in the database.

    * User sets the database connection
    * prepare query for courier_statements table
    * List and verify how many different deliverers the parcel was transported by
    * Database connection is closed

  @DB_US07
  Scenario: Verify the data containing 'A' in the code information of the contents with name=Dollars
            in the currencies table via the database by reversing the order.

    * User sets the database connection
    * prepare query for currencies table
    * verify the data with 'A' in the code information of the contents with name=Dollars by sorting them in reverse order.
    * Database connection is closed

  @DB_US08
  Scenario: Make a data record by entering all data into the delivery charges table via the database and
            verify that a new record can be made. (status should be 0)

    * User sets the database connection
    * prepare query for delivery_charges table
    * make a new registration and verify that a new registration can be made
    * Database connection is closed






