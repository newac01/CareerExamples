<!DOCTYPE html>
<style>
    .courses {
    margin: auto;
    width: 70%
}

table {
    width: auto;
}

table, td,th{border:1px solid;
}
th {
    letter-spacing: 0.1em;
    font-size: 90%;
}

</style>
<html>
    <head>
        <meta name="viewport" content="width=device-width">
        <Title>Courses </Title>
    </head>
    <body>
        <?php
            require_once('db_con.php');
            //echo "connected successfully";
            require_once('create_table.php');
            
                // //check for error in insert
                // if (!$result) {
                // throw new Exception("Database Error [{$connection->errno}] {$connection->error}");
                // }
                                            
                //select data
                $sql = "SELECT semester,course FROM courseTable";
                //check for error in select
                $result = $connection->query($sql);  
                if (!$result) {
                    throw new Exception("Database Error [{$connection->errno}] {$connection->error}");
                }
                echo "<table id='courses'> 
                    <tr>
                        <th>Semester</th>
                        <th>Course</th>
                    </tr>";
            //output data to page
            while ($user = $result->fetch_assoc())
            {
                echo "<tr>
                    <td>" . $user["semester"]. "</td>
                    <td>" . $user["course"]. "</td>
                    </tr>";
            }
            echo "</table>";
        ?>
    </body>
</html>