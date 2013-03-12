document.addEventListener('DOMContentLoaded', function() 
{
    loadNavigator();
    search();
    spinEffect();
    emptyCart();
});

function loadNavigator()
{
    var url = document.URL.replace(/.*\//, '');
    var nav = document.getElementById("navigator").getElementsByTagName("li");

    url = url.replace("?statusCode=303", '');

    if (url === "home" || url === "categories")
        nav[0].className = "active";
    else if (url === "search")
        nav[2].className = "active";
    else if (url === "orders")
        nav[2].className = "active";
    else
        nav[1].className = "active";
}

function search()
{
    var search = document.getElementById("form-search");
    if (search != null)
    {
        search.addEventListener("submit", function(e) 
        {
            var $this = $(this);
            var id = $this.serialize().substring(3);
            window.location.href = "/orders/" + id;
            e.preventDefault();
        });
    }
}

function emptyCart()
{
    var empty = document.getElementById("empty");
    if (empty != null) 
    {
        empty.addEventListener("click", function(e) 
        {
            var msg = 'Are you sure you want to empty the cart ?';
            customConfirm(msg);
            e.preventDefault();
        });
    }
}

function customConfirm(message, true_func, false_func){
    var container = document.createElement('div');
    //template for modal window
    container.innerHTML += '<div class="modal custom-confirm">'+
        '<div class="modal-body">' +
        '<div>' + message + '</div>' +
        '<div class="controls">' + 
        '<form action="carts/empty" method"post" id="empty-cart-form">' +
        '<input type="hidden" name="_method" value="delete"/>' +
        '<button type="submit" class="btn btn-remove">OK</button>' +
        '<button type="button" class="btn">Cancel</button>' +
        '</form>' +
        '</div>' +
        '</div>' +
        '</div>';
    //modal window
    var modal = container.firstChild;
    container = document.createElement('div');
    container.innerHTML = '<div class="modal-backdrop  in"></div>';
    //dark background
    var background = container.firstChild;
    //get click OK button
    var ok = modal.getElementsByTagName('button')[0];
    ok.onclick = function() {
        modal.parentNode.removeChild(modal);
        document.body.removeChild(background);
        true_func();
    }
    //get click Cancel button
    var cancel = modal.getElementsByTagName('button')[1];
    cancel.onclick = function() {
        modal.parentNode.removeChild(modal);
        document.body.removeChild(background);
        false_func();
    }
    document.body.appendChild(background);
    document.body.appendChild(modal);
}

function spinEffect()
{
    $("#btn-update-cart").mouseover(function() {
        $("i", this).removeClass();
        $("i", this).addClass("icon-refresh icon-spin icon-large");
    }).mouseout(function(){
        $("i", this).removeClass();
        $("i", this).addClass("icon-repeat icon-large");
    });
}
