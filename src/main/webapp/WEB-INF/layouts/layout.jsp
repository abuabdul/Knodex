<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Knodex is an indexing application to order and index whatever we have gathered into the it.">
    <meta name="author" content="Abubacker Siddik A, abuabdul.com">
    <link rel="shortcut icon" href="ico/favicon.png">

    <title><tiles:insertAttribute name="title" ignore="true" /></title>

    <tiles:insertAttribute name="siteJS"/>
  </head>

  <body>

    <tiles:insertAttribute name="header"/>

    <tiles:insertAttribute name="logoAndIndexer"/>
    
    <tiles:insertAttribute name="body"/>
    
    <tiles:insertAttribute name="footer"/>
    
  </body>
</html>