<div class="starter-template">
    <form class="form-horizontal" role="form" id='login-form' method='POST' action='/'>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="username">Username: </label>
            <div class="col-sm-5">
                <input class="form-control" type='text' id="username" name='username' placeholder="Enter username" />
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="password">Password: </label>
            <div class="col-sm-5">
                <input class="form-control" type='password' id="password" name='password' placeholder="Enter password" />
            </div>
        </div>
    </form>
    <input type='submit' value='Login' class="btn btn-primary" form='login-form' />
</div>