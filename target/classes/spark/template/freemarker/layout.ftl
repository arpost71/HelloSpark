<html>
    <head>
        <title>ReadingNET</title>
        <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="http://getbootstrap.com/examples/starter-template/starter-template.css">
    </head>
    <body>

        <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/"><span class="glyphicon glyphicon-home"></span> ReadingNET</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="/view"><span class="glyphicon glyphicon-book" aria-hidden="true"></span> View Books</a></li>
                        <li><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Edit Books <span class="caret"></span></a>
                             <ul class="dropdown-menu" role="menu">
                                <li><a href="/delete">Edit Books</a></li>
                                <li><a href="/add">Add Books</a></li>
                             </ul>
                        </li>
                        <li><a href="/clients">Clients</a></li>
                        <li><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Account <span class="caret"></span></a>
                             <ul class="dropdown-menu" role="menu">
                                <li><a href="/account">My Account</a></li>
                                <li><a href="/logout">Log out</a></li>
                             </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="container">
            <#include "${templateName}">
        </div>

        <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
    </body>
</html>


