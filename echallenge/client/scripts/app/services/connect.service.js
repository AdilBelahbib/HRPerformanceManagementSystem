app.service('connect', function () {
        var property ='none' ;

        return {
            getProperty: function () {
                return property;
            },
            setProperty: function(value) {
                property = value;
            }
        };
    });