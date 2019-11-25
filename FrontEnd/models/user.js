class user{
    constructor(id_user,password){
        this.id_user = id_user;
        this.password = password;
    }

    getUser(){
        return this.id_user;
    }
    getPass(){
        return this.password;
    }
}

function validateUser(){
    var usuario,pass;
    usuario = $('#uname1').val();
    pass = $('pwd1').val();
    const ObjUser = new user(usuario,pass);
    location.href="/FrontEnd/modules/serviceModule/Service.html";
}



