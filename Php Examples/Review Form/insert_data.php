<?php
    require_once('db_con.php');
    //insert statement
    $sql = "INSERT INTO review (id, name, email, referrer, rating, comment)
                VALUES( '', '$name','$email','$source','$answer','$comment'
                    )";
    $result = $connection->query($sql);  
    if (!$result) {
        throw new Exception("Database Error [{$connection->errno}] {$connection->error}");
    }
?>