<?php
    
    define("USER", "test");
    define("PASS", "test");
    define("DB", "test");

    // connect to database
    $connection = new mysqli('localhost', USER, PASS, DB);

    if ($connection->connect_error) {
        die('Connect Error (' . $connection->connect_errno .') '.$connection->connect_error);
    }
 
?>