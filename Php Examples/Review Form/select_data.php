<?php
    require_once('db_con.php');
        // execute query 
    $sql = "SELECT id, name, email, referrer, rating, comment FROM review";
    //check for error in select
    $result = $connection->query($sql);  
    if (!$result) {
        throw new Exception("Database Error [{$connection->errno}] {$connection->error}");
    }
?>