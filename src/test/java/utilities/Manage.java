package utilities;

public class Manage {

    public String getQuery01() {
        return query01;
    }
    public String getQuery02() {
        return query02;
    }
    public String getQuery03() { return query03; }
    public String getQuery04() { return query04; }
    public String getQuery05() { return query05; }
    public String getQuery06() { return query06; }
    public String getQuery07() { return query07; }
    public String getQuery08() { return query08; }
    public String getQuery09() { return query09; }

    private String query01 = "select count(*)  from u168183796_qaagiles.accounts where gateway = 2 ";
    private String query02 = "select title FROM u168183796_qaagiles.blogs ORDER BY views DESC LIMIT 1";
    private String query03 = "select count(*) as user_count from u168183796_qaagiles.activity_log where log_name = 'User'";
    private String query04 = "select count(*) as user_count from u168183796_qaagiles.activity_log where log_name = 'Upload'";
    private String query05 = "select date FROM u168183796_qaagiles.bank_transactions ORDER BY date ASC LIMIT 5";
    private String query06 = "select amount FROM u168183796_qaagiles.bank_transactions where date between '2023-08-23 11:30:34' AND  '2023-10-01 20:44:08' ORDER BY amount ASC";
    private String query07 = "select parcel_id, COUNT(DISTINCT type) AS unique_couriers FROM u168183796_qaagiles.courier_statements GROUP BY parcel_id";
    private String query08 = "select * FROM u168183796_qaagiles.currencies WHERE name = 'Dollars' AND code LIKE '%A%' ORDER BY code DESC";
    private String query09 = "INSERT INTO u168183796_qaagiles.delivery_charges (id, category_id, weight, same_day,next_day,sub_city,status) VALUES ('40', '2', '6','10.00','12.00','90.00', 0)";
}
