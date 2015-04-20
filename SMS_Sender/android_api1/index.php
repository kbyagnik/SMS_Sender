<?php

/**
 * File to handle all API requests
 * Accepts GET and POST
 * 
 * Each request will be identified by TAG
 * Response will be JSON data
 parameters.put("tag", "putsms");
                parameters.put("address",sender);
                parameters.put("tym",ts);
                parameters.put("messg", txt);
  /**
 * check for POST request 
 */
if (isset($_POST['tag']) && $_POST['tag'] != '') {
    // get tag
    $tag = $_POST['tag'];

    // include db handler
    require_once 'include/DB_Functions.php';
    $db = new DB_Functions();

    // response Array
    $response = array("tag" => $tag, "error" => FALSE);

    // check for tag type
    if ($tag == 'putsms') {
        // Request type is Register new user
	//$unique_id = $_POST['uid'];
//	$unique_id = "aa";
        $address = $_POST['address'];
        $msgbody = $_POST['messg'];
        $tymstamp = $_POST['tym'];

        $users = $db->storemsg($address, $msgbody, $tymstamp);
        
            if ($storemsg) {
                // user stored successfully
                $response["error"] = FALSE;
           
               echo json_encode($response);
		//echo "Song inserted" ; 
            } else {
                // user failed to store
                $response["error"] = TRUE;
                $response["error_msg"] = "Error occured in Database insertion";
                echo json_encode($response);
            }
      // }   
    }

    else if ($tag == 'status') {
        // Request type is Register new user
	//$unique_id = $_POST['uid'];
//	$unique_id = "aa";
        $idd = $_POST['uid'];
	//echo $idd;
        $booking_status = $db->getstatusofId($idd);
        
            if ($booking_status) {
                // user stored successfully
                $response["error"] = FALSE;
           	$response["error_msg"] = "Success attained";
		$response["status"]= $booking_status["status"];
               echo json_encode($response);
		  
            } else {
                // user failed to store
                $response["error"] = TRUE;
                $response["error_msg"] = "Error occured in Getting status";
                echo json_encode($response);
            }
      // }   
    } 
 
    
    
    else {
        // user failed to store
        $response["error"] = TRUE;
        $response["error_msg"] = $response["tag"];//"Unknow 'tag' value. It should be either 'login' or 'register'";
        echo json_encode($response);
    }
} else {
    $response["error"] = TRUE;
    $response["error_msg"] = "Required parameter 'tag' is missing!";
    echo json_encode($response);
}
?>
