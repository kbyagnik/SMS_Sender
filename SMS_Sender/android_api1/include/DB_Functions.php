<?php

class DB_Functions {

    private $db;

    //put your code here
    // constructor
    function __construct() {
        require_once 'DB_Connect.php';
        // connecting to database
        $this->db = new DB_Connect();
        $this->db->connect();
    }

    // destructor
    function __destruct() {
        
    }
    public function getstatusofId($uid) {
	//echo $uid;
        $result1 = mysql_query("SELECT * FROM booking_status where id='$uid'") or die(mysql_error());
        // check for result 
	
        $no_of_rows = mysql_num_rows($result1);
	//echo $no_of_rows;	
	if ($no_of_rows > 0) {
            $result2 = mysql_fetch_array($result1);
		//echo json_encode($result2);                
		return $result2;
        } else {
            // user not found
            return false;
        }
    }
    
    public function storemsg($add, $body, $tym) {

        $result = mysql_query("INSERT INTO users(sender, body, created_at) VALUES('$add', '$body', '$tym')");
        // check for successful store
        if ($result) {
            // get user details 
           // $uid = mysql_insert_id(); // last inserted id
            $result = mysql_query("SELECT * FROM users WHERE uid = $unique_id");
            // return user details
            return mysql_fetch_array($result);
        } else {
            return false;
        }
    }

	
    

}

?>
