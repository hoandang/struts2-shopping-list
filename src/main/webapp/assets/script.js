document.addEventListener('DOMContentLoaded', function() {
    loadNavigator();
    document.getElementById("empty").addEventListener("click", function(e){
        var msg = 'Are you sure you want to empty the cart ?';
        customConfirm(msg);
        ////customConfirm(msg, function(){alert('id deleted')},function(){alert('user pressed Cancel button')}); 
        e.preventDefault();
    });
});

function loadNavigator()
{
    var url = document.URL.replace(/.*\//, '');
    url = url.replace("?statusCode=303", '');
    var nav = document.getElementById("navigator").getElementsByTagName("li");
    for (var i = 0; i < nav.length; i++)
    {
        if (nav[i].getAttribute("data-url") === url)
            nav[i].className = "active";
        else if (nav[i].getAttribute("data-url") === url)
            nav[i].className = "active";
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