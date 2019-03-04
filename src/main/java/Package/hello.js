$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8060/create"
    }).then(function(data) {
        $('.AddressBook-id').append(data.id);
        $('.AddressBook-content').append(data.content);
    });
});