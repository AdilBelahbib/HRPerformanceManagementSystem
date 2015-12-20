    'use strict';

    app
    .factory('DemandeBip', function ($resource, $filter) {

        return $resource('/resources/demandebips/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'collaborateur' : { 
                method: 'GET',
                isArray : true,
                url: '/resources/demandebips/collaborateur/:id'
            },
            'manager' : { 
                method: 'GET',
                isArray : true,
                url: '/resources/demandebips/manager/:id'
            },
            'encadrant' :
            {
               method: 'GET',
               url: '/resources/demandebips/encadrant/:id'
           },
           'update': { method:'PUT' },
           'save': { method:'POST' }
       });
    });
