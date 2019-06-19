<?php
    require_once('db_con.php');
    //create a table
     $sql = "CREATE TABLE IF NOT EXISTS courseTable(
            id INT( 11 ) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
            semester VARCHAR( 50 ) NOT NULL ,
            course VARCHAR( 50 ) NOT NULL
            )";
        
    if($connection->query($sql) === TRUE){
        //echo "Table courseTable created successfully\n";
    }else{
        echo "Error creating table: " . $connection->error;
    }
?>