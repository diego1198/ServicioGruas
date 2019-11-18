<?php

require('php/Connection.php');

$query= "SELECT cmid,cmuser FROM cranemanager order by cmuser ASC" ;
$response =$mysqli->query($query);



?>






<!doctype html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ServiGruas-Nuñez</title>
    <link rel="stylesheet" href="css/style1.css">
    <script type="text/javascript" src="js/validate.js"></script>

    <script language="javascript" src="js/list.js"></script>
     <link rel="stylesheet" type="text/css" href="/FrontEnd/css/bootstrap.css">
    <script type="text/javascript" src="/FrontEnd/js/bootstrap.js"></script>
    <script type="text/javascript" src="/FrontEnd/js/jquery-3.4.1.min.js"></script>


</head>

<body>
    <div class="container">
        <div class="py-5 text-center">
        <h2 > <b>ENTER YOUR INFORMATION</b> </h2>
        </div>
        

        <form  class="needs-validation" action="service.js" method="POST"  id="formOperator" onsubmit="return validateForm();">
           
          <div class="col-md-6 mb-3">
            <label for="model">Name: </label>
            <input class="form-control" type="text" id="name" placeholder="Henry"> <br>
          </div>
          <div class="col-md-6 mb-3">
            <label for="model">Last Name: </label>
            <input class="form-control" type="text" id="lastname" placeholder="Aguaiza"> <br>
          </div>
          <div class="col-md-6 mb-3">
            <label for="model">Id: </label>
            <input class="form-control" type="text" id="id" placeholder="1719568378"><br>
          </div>
        
          <div class="col-md-6 mb-3">
             <label for="model">Driver's license: </label>

              <select id="license" class="form-control">
                <option value="0">SELECT A LICENSE</option>
                <option value="1">A</option>
                <option value="2">B</option>
                <option value="3">F</option>
                <option value="4">A1</option>
                <option value="5">C</option>
                <option value="6">C1</option>
                <option value="7">D</option>
                <option value="8">D1</option>
                <option value="9">E</option>
                <option value="10">E1</option>
                <option value="11">G</option>
             </select>

          </div >



          <div class="col-md-6 mb-3">


          <label for="model">Crane Manager: </label>
            <select id="craneManager" class="form-control">
                    <option value="0">SELECT A CRANE MANAGER</option>
                    <?php 
                    $cont=0;  
                    while($row = $response->fetch_assoc()) { ?>
                        <option value="<?php $cont++; ?>"> <?php echo $row['cmid']. '-'. $row['cmuser'] ; ?>   </option>

                    <?php }?>
                    
            </select> <br>
          </div>

         <div class="col-md-6 mb-3">
                <center>
                    <input  class="btn btn-success btn-lg" type="submit" value="Create" id="submit">
                </center>

         </div>

           

            
           

        </form>

       
    </div>
    <footer class="footer text-faded text-center py-5">
        <div class="container">
            <p class="m-0 small"><h4>Copyright &copy; ESPE - Gruas Service 2019</h4></p>
        </div>
    </footer>
        
</body>

</html>