<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Knodex is an indexing application to order and index whatever we have added into the it.">
    <meta name="author" content="Abubacker Siddik A, abuabdul.com">
    <link rel="shortcut icon" href="ico/favicon.png">

    <title>Knodex - Knowledge Indexing Tool</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/knodex.css"/>" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="<c:url value="/resources/js/ie8-responsive-file-warning.js"/>"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <!-- Fixed navbar -->
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="active"><a href="javascript:alert('hi');">About</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="index-fixed">
     <div class="container">

      <!-- Main Index Adder -->
      <div class="jumbotron">
			<div class="input-group input-group-lg">
				<span class="input-group-btn input-group-btn-lg">
					<button class="btn btn-lg btn-primary" type="button">
					  <span class="glyphicon glyphicon-book"></span>
					   Index it...!
					</button>
				</span> <input type="text" class="form-control" placeholder="Add Anything to Index">
			</div>
			<!-- /input-group -->
			<p width="100%" align="center">
			   <span class="indexpad"><a class="badge" href="#">A</a></span>
			   <span class="indexpad"><a class="badge" href="#">B</a></span>
			   <span class="indexpad"><a class="badge" href="#">C</a></span>
			   <span class="indexpad"><a class="badge" href="#">D</a></span>
			   <span class="indexpad"><a class="badge" href="#">E</a></span>
			   <span class="indexpad"><a class="badge" href="#">F</a></span>
			   <span class="indexpad"><a class="badge" href="#">G</a></span>
			   <span class="indexpad"><a class="badge" href="#">H</a></span>
			   <span class="indexpad"><a class="badge" href="#">I</a></span>
			   <span class="indexpad"><a class="badge" href="#">J</a></span>
			   <span class="indexpad"><a class="badge" href="#">K</a></span>
			   <span class="indexpad"><a class="badge" href="#">L</a></span>
			   <span class="indexpad"><a class="badge" href="#">M</a></span>
			   <span class="indexpad"><a class="badge" href="#">N</a></span>
			   <span class="indexpad"><a class="badge" href="#">O</a></span>
			   <span class="indexpad"><a class="badge" href="#">P</a></span>
			   <span class="indexpad"><a class="badge" href="#">Q</a></span>
			   <span class="indexpad"><a class="badge" href="#">R</a></span>
			   <span class="indexpad"><a class="badge" href="#">S</a></span>
			   <span class="indexpad"><a class="badge" href="#">T</a></span>
			   <span class="indexpad"><a class="badge" href="#">U</a></span>
			   <span class="indexpad"><a class="badge" href="#">V</a></span>
			   <span class="indexpad"><a class="badge" href="#">W</a></span>
			   <span class="indexpad"><a class="badge" href="#">X</a></span>
			   <span class="indexpad"><a class="badge" href="#">Y</a></span>
			   <span class="indexpad"><a class="badge" href="#">Z</a></span>
           </p>
      </div>

     </div> <!-- /container -->
    </div>  <!-- /index-fixed -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
  </body>
</html>