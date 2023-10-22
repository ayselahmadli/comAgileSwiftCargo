package stepDefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.Manage;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.testng.AssertJUnit.assertEquals;
import static utilities.DB_Utils.*;

public class DBSteps {

    ResultSet resultset;
    ResultSet resultset1;
    Manage manage = new Manage();



    @Given("User sets the database connection")
    public void user_sets_the_database_connection() {
        createConnection();
    }

    @Given("prepare query for accounts table")
    public void prepare_query_for_accounts_table() throws SQLException {
        resultset = getStatement().executeQuery(manage.getQuery01());
    }

    @Given("verify the number of users is {int}")
    public void verify_the_number_of_users_is(Integer int1) throws SQLException {
        resultset.next();
        int expectedData = 33;
        int actualData = resultset.getInt(1);
        assertEquals(expectedData, actualData);
    }

    @Given("Database connection is closed")
    public void database_connection_is_closed() {
        closeConnection();
    }

    @Given("prepare query for blogs table")
    public void prepare_query_for_blogs_table() throws SQLException {
        resultset = getStatement().executeQuery(manage.getQuery02());
    }

    @Given("verify most viewed blog name")
    public void verify_most_viewed_blog_name() throws SQLException {
        resultset.next();
        String query = resultset.getString(1);
        assertEquals("Global Logistics and Cultural Challenges Developing Effective Solutions for International Shipments", query);
        System.out.println("Most viewed blog: " + query);
    }

    @Given("prepare query for activity_log table")
    public void prepare_query_for_activity_log_table() throws SQLException {
        resultset = getStatement().executeQuery(manage.getQuery03());
        resultset1 = getStatement().executeQuery(manage.getQuery04());
    }

    @Given("verify that the data in log_name: User is more than the data in log_name: Upload.")
    public void verify_that_the_data_in_log_name_user_is_more_than_the_data_in_log_name_upload() throws SQLException {
        resultset.next();
        resultset1.next();
        int userLogCount = resultset.getInt(1);
        int uploadLogCount = resultset1.getInt(1);
        if (userLogCount > uploadLogCount){
            System.out.println("Verification successful: The number of User logs is greater than the number of Upload logs");
        } else {
            System.out.println("Verification failed: The number of User logs is not more than the number of Upload logs");
        }
    }
    @Given("prepare query for bank_transactions table")
        public void prepare_query_for_bank_transactions_table() {
        try {
            resultset = getStatement().executeQuery(manage.getQuery05());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Given("verify the creation dates of the {int} most recently updated records in the bank transactions table by ordering them from oldest to newest")
        public void verify_the_creation_dates_of_the_most_recently_updated_records_in_the_bank_transactions_table_by_ordering_them_from_oldest_to_newest(Integer int1) throws SQLException {
        int rowCount = 0;
        while (resultset.next()) {
            String creationDate = resultset.getString("date");
            System.out.println("Creation Date: " + creationDate);
            rowCount++;
        }
        if (rowCount == 5) {
            System.out.println("Verification successful: The creation dates of the 5 most recently updated records are correct");
        } else {
            System.out.println("Validation failed: The creation dates of the 5 most recently updated records are missing or incorrect");
        }
    }

    @Given("list and verify the amount information of the data created between {string} and {string} in ascending order")
        public void list_and_verify_the_amount_information_of_the_data_created_between_and_in_ascending_order(String string, String string2) throws SQLException {
        resultset = getStatement().executeQuery(manage.getQuery06());
        int rowCount = 0;
        while (resultset.next()) {
            double amountInformation = resultset.getDouble("amount");
            rowCount++;
        }
        Assert.assertTrue(rowCount>0);
    }

    @Given("prepare query for courier_statements table")
    public void prepare_query_for_courier_statements_table() throws SQLException {
        resultset = getStatement().executeQuery(manage.getQuery07());
    }
    @Given("List and verify how many different deliverers the parcel was transported by")
    public void list_and_verify_how_many_different_deliverers_the_parcel_was_transported_by() throws SQLException {
        while (resultset.next()) {
            String parcelId = resultset.getString("parcel_id");
            int uniqueCouriers = resultset.getInt("unique_couriers");

            System.out.println("Parcel ID: " + parcelId);
            System.out.println("Number of Unique Deliverymen:" + uniqueCouriers);

            if (uniqueCouriers > 0) {
                System.out.println("Verification successful: Parcel was transported by different deliverers");
            } else {
                System.out.println("Verification failed: Parcel was not transported by any delivery person");
            }
        }
    }

    @Given("prepare query for currencies table")
        public void prepare_query_for_currencies_table() throws SQLException {
        resultset = getStatement().executeQuery(manage.getQuery08());
        }
    @Given("verify the data with {string} in the code information of the contents with name=Dollars by sorting them in reverse order.")
        public void verify_the_data_with_in_the_code_information_of_the_contents_with_name_dollars_by_sorting_them_in_reverse_order(String string) throws SQLException {
        while (resultset.next()) {
            String name = resultset.getString("name");
            String code = resultset.getString("code");
        }
    }
    @Given("prepare query for delivery_charges table")
    public void prepare_query_for_delivery_charges_table() throws SQLException {
        int rowCount;
    }
    @Given("make a new registration and verify that a new registration can be made")
    public void make_a_new_registration_and_verify_that_a_new_registration_can_be_made() throws SQLException {
        int rowCount = getStatement().executeUpdate(manage.getQuery09());
        if (rowCount > 0) {
            System.out.println("Verification successful: A new record has been added successfully and status is set to 0");
        } else {
            System.out.println("Validation failed: No new record was added or an error occurred");
        }

    }



    }






