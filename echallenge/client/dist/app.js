var app=angular.module('hrPerformanceApp',['ui.router','ngResource','ngCookies']);
app.config(['$locationProvider', function($scope,$locationProvider, Utilisateur) {
     // 

 }]);
app.config(function ($stateProvider, $urlRouterProvider, $httpProvider, $locationProvider) {

        //enable CSRF
        

        
        $stateProvider.state('site', {
            'abstract': true,
            views: {
                'navbar@': {
                    templateUrl: 'scripts/components/navbar/navbar.html',
                    controller: 'NavbarController'
                }
            },
            resolve: {
                // authorize: ['Auth',
                //     function (Auth) {
                //         return Auth.authorize();
                //     }
                // ]
            }
        });

    });

app.controller('mainController', function ($scope, $state, $cookieStore,$stateParams,$filter ) {


    $scope.logOut = function  () {

        $cookieStore.remove('connectedUser');
        $cookieStore.remove('logged');    
        $state.go('login');
    }

    
});







console.log('after-config');


;/**
 * @license AngularJS v1.5.0-rc.0
 * (c) 2010-2015 Google, Inc. http://angularjs.org
 * License: MIT
 */
(function(window, angular, undefined) {'use strict';

/**
 * @ngdoc module
 * @name ngCookies
 * @description
 *
 * # ngCookies
 *
 * The `ngCookies` module provides a convenient wrapper for reading and writing browser cookies.
 *
 *
 * <div doc-module-components="ngCookies"></div>
 *
 * See {@link ngCookies.$cookies `$cookies`} for usage.
 */


angular.module('ngCookies', ['ng']).
  /**
   * @ngdoc provider
   * @name $cookiesProvider
   * @description
   * Use `$cookiesProvider` to change the default behavior of the {@link ngCookies.$cookies $cookies} service.
   * */
   provider('$cookies', [function $CookiesProvider() {
    /**
     * @ngdoc property
     * @name $cookiesProvider#defaults
     * @description
     *
     * Object containing default options to pass when setting cookies.
     *
     * The object may have following properties:
     *
     * - **path** - `{string}` - The cookie will be available only for this path and its
     *   sub-paths. By default, this would be the URL that appears in your base tag.
     * - **domain** - `{string}` - The cookie will be available only for this domain and
     *   its sub-domains. For obvious security reasons the user agent will not accept the
     *   cookie if the current domain is not a sub domain or equals to the requested domain.
     * - **expires** - `{string|Date}` - String of the form "Wdy, DD Mon YYYY HH:MM:SS GMT"
     *   or a Date object indicating the exact date/time this cookie will expire.
     * - **secure** - `{boolean}` - The cookie will be available only in secured connection.
     *
     * Note: by default the address that appears in your `<base>` tag will be used as path.
     * This is important so that cookies will be visible for all routes in case html5mode is enabled
     *
     **/
    var defaults = this.defaults = {};

    function calcOptions(options) {
      return options ? angular.extend({}, defaults, options) : defaults;
    }

    /**
     * @ngdoc service
     * @name $cookies
     *
     * @description
     * Provides read/write access to browser's cookies.
     *
     * <div class="alert alert-info">
     * Up until Angular 1.3, `$cookies` exposed properties that represented the
     * current browser cookie values. In version 1.4, this behavior has changed, and
     * `$cookies` now provides a standard api of getters, setters etc.
     * </div>
     *
     * Requires the {@link ngCookies `ngCookies`} module to be installed.
     *
     * @example
     *
     * ```js
     * angular.module('cookiesExample', ['ngCookies'])
     *   .controller('ExampleController', ['$cookies', function($cookies) {
     *     // Retrieving a cookie
     *     var favoriteCookie = $cookies.get('myFavorite');
     *     // Setting a cookie
     *     $cookies.put('myFavorite', 'oatmeal');
     *   }]);
     * ```
     */
    this.$get = ['$$cookieReader', '$$cookieWriter', function($$cookieReader, $$cookieWriter) {
      return {
        /**
         * @ngdoc method
         * @name $cookies#get
         *
         * @description
         * Returns the value of given cookie key
         *
         * @param {string} key Id to use for lookup.
         * @returns {string} Raw cookie value.
         */
        get: function(key) {
          return $$cookieReader()[key];
        },

        /**
         * @ngdoc method
         * @name $cookies#getObject
         *
         * @description
         * Returns the deserialized value of given cookie key
         *
         * @param {string} key Id to use for lookup.
         * @returns {Object} Deserialized cookie value.
         */
        getObject: function(key) {
          var value = this.get(key);
          return value ? angular.fromJson(value) : value;
        },

        /**
         * @ngdoc method
         * @name $cookies#getAll
         *
         * @description
         * Returns a key value object with all the cookies
         *
         * @returns {Object} All cookies
         */
        getAll: function() {
          return $$cookieReader();
        },

        /**
         * @ngdoc method
         * @name $cookies#put
         *
         * @description
         * Sets a value for given cookie key
         *
         * @param {string} key Id for the `value`.
         * @param {string} value Raw value to be stored.
         * @param {Object=} options Options object.
         *    See {@link ngCookies.$cookiesProvider#defaults $cookiesProvider.defaults}
         */
        put: function(key, value, options) {
          $$cookieWriter(key, value, calcOptions(options));
        },

        /**
         * @ngdoc method
         * @name $cookies#putObject
         *
         * @description
         * Serializes and sets a value for given cookie key
         *
         * @param {string} key Id for the `value`.
         * @param {Object} value Value to be stored.
         * @param {Object=} options Options object.
         *    See {@link ngCookies.$cookiesProvider#defaults $cookiesProvider.defaults}
         */
        putObject: function(key, value, options) {
          this.put(key, angular.toJson(value), options);
        },

        /**
         * @ngdoc method
         * @name $cookies#remove
         *
         * @description
         * Remove given cookie
         *
         * @param {string} key Id of the key-value pair to delete.
         * @param {Object=} options Options object.
         *    See {@link ngCookies.$cookiesProvider#defaults $cookiesProvider.defaults}
         */
        remove: function(key, options) {
          $$cookieWriter(key, undefined, calcOptions(options));
        }
      };
    }];
  }]);

angular.module('ngCookies').
/**
 * @ngdoc service
 * @name $cookieStore
 * @deprecated
 * @requires $cookies
 *
 * @description
 * Provides a key-value (string-object) storage, that is backed by session cookies.
 * Objects put or retrieved from this storage are automatically serialized or
 * deserialized by angular's toJson/fromJson.
 *
 * Requires the {@link ngCookies `ngCookies`} module to be installed.
 *
 * <div class="alert alert-danger">
 * **Note:** The $cookieStore service is **deprecated**.
 * Please use the {@link ngCookies.$cookies `$cookies`} service instead.
 * </div>
 *
 * @example
 *
 * ```js
 * angular.module('cookieStoreExample', ['ngCookies'])
 *   .controller('ExampleController', ['$cookieStore', function($cookieStore) {
 *     // Put cookie
 *     $cookieStore.put('myFavorite','oatmeal');
 *     // Get cookie
 *     var favoriteCookie = $cookieStore.get('myFavorite');
 *     // Removing a cookie
 *     $cookieStore.remove('myFavorite');
 *   }]);
 * ```
 */
 factory('$cookieStore', ['$cookies', function($cookies) {

    return {
      /**
       * @ngdoc method
       * @name $cookieStore#get
       *
       * @description
       * Returns the value of given cookie key
       *
       * @param {string} key Id to use for lookup.
       * @returns {Object} Deserialized cookie value, undefined if the cookie does not exist.
       */
      get: function(key) {
        return $cookies.getObject(key);
      },

      /**
       * @ngdoc method
       * @name $cookieStore#put
       *
       * @description
       * Sets a value for given cookie key
       *
       * @param {string} key Id for the `value`.
       * @param {Object} value Value to be stored.
       */
      put: function(key, value) {
        $cookies.putObject(key, value);
      },

      /**
       * @ngdoc method
       * @name $cookieStore#remove
       *
       * @description
       * Remove given cookie
       *
       * @param {string} key Id of the key-value pair to delete.
       */
      remove: function(key) {
        $cookies.remove(key);
      }
    };

  }]);

/**
 * @name $$cookieWriter
 * @requires $document
 *
 * @description
 * This is a private service for writing cookies
 *
 * @param {string} name Cookie name
 * @param {string=} value Cookie value (if undefined, cookie will be deleted)
 * @param {Object=} options Object with options that need to be stored for the cookie.
 */
function $$CookieWriter($document, $log, $browser) {
  var cookiePath = $browser.baseHref();
  var rawDocument = $document[0];

  function buildCookieString(name, value, options) {
    var path, expires;
    options = options || {};
    expires = options.expires;
    path = angular.isDefined(options.path) ? options.path : cookiePath;
    if (angular.isUndefined(value)) {
      expires = 'Thu, 01 Jan 1970 00:00:00 GMT';
      value = '';
    }
    if (angular.isString(expires)) {
      expires = new Date(expires);
    }

    var str = encodeURIComponent(name) + '=' + encodeURIComponent(value);
    str += path ? ';path=' + path : '';
    str += options.domain ? ';domain=' + options.domain : '';
    str += expires ? ';expires=' + expires.toUTCString() : '';
    str += options.secure ? ';secure' : '';

    // per http://www.ietf.org/rfc/rfc2109.txt browser must allow at minimum:
    // - 300 cookies
    // - 20 cookies per unique domain
    // - 4096 bytes per cookie
    var cookieLength = str.length + 1;
    if (cookieLength > 4096) {
      $log.warn("Cookie '" + name +
        "' possibly not set or overflowed because it was too large (" +
        cookieLength + " > 4096 bytes)!");
    }

    return str;
  }

  return function(name, value, options) {
    rawDocument.cookie = buildCookieString(name, value, options);
  };
}

$$CookieWriter.$inject = ['$document', '$log', '$browser'];

angular.module('ngCookies').provider('$$cookieWriter', function $$CookieWriterProvider() {
  this.$get = $$CookieWriter;
});


})(window, window.angular);
;/**
 * @license AngularJS v1.4.0
 * (c) 2010-2015 Google, Inc. http://angularjs.org
 * License: MIT
 */
(function(window, angular, undefined) {'use strict';

var $resourceMinErr = angular.$$minErr('$resource');

// Helper functions and regex to lookup a dotted path on an object
// stopping at undefined/null.  The path must be composed of ASCII
// identifiers (just like $parse)
var MEMBER_NAME_REGEX = /^(\.[a-zA-Z_$@][0-9a-zA-Z_$@]*)+$/;

function isValidDottedPath(path) {
  return (path != null && path !== '' && path !== 'hasOwnProperty' &&
      MEMBER_NAME_REGEX.test('.' + path));
}

function lookupDottedPath(obj, path) {
  if (!isValidDottedPath(path)) {
    throw $resourceMinErr('badmember', 'Dotted member path "@{0}" is invalid.', path);
  }
  var keys = path.split('.');
  for (var i = 0, ii = keys.length; i < ii && obj !== undefined; i++) {
    var key = keys[i];
    obj = (obj !== null) ? obj[key] : undefined;
  }
  return obj;
}

/**
 * Create a shallow copy of an object and clear other fields from the destination
 */
function shallowClearAndCopy(src, dst) {
  dst = dst || {};

  angular.forEach(dst, function(value, key) {
    delete dst[key];
  });

  for (var key in src) {
    if (src.hasOwnProperty(key) && !(key.charAt(0) === '$' && key.charAt(1) === '$')) {
      dst[key] = src[key];
    }
  }

  return dst;
}

/**
 * @ngdoc module
 * @name ngResource
 * @description
 *
 * # ngResource
 *
 * The `ngResource` module provides interaction support with RESTful services
 * via the $resource service.
 *
 *
 * <div doc-module-components="ngResource"></div>
 *
 * See {@link ngResource.$resource `$resource`} for usage.
 */

/**
 * @ngdoc service
 * @name $resource
 * @requires $http
 *
 * @description
 * A factory which creates a resource object that lets you interact with
 * [RESTful](http://en.wikipedia.org/wiki/Representational_State_Transfer) server-side data sources.
 *
 * The returned resource object has action methods which provide high-level behaviors without
 * the need to interact with the low level {@link ng.$http $http} service.
 *
 * Requires the {@link ngResource `ngResource`} module to be installed.
 *
 * By default, trailing slashes will be stripped from the calculated URLs,
 * which can pose problems with server backends that do not expect that
 * behavior.  This can be disabled by configuring the `$resourceProvider` like
 * this:
 *
 * ```js
     app.config(['$resourceProvider', function($resourceProvider) {
       // Don't strip trailing slashes from calculated URLs
       $resourceProvider.defaults.stripTrailingSlashes = false;
     }]);
 * ```
 *
 * @param {string} url A parameterized URL template with parameters prefixed by `:` as in
 *   `/user/:username`. If you are using a URL with a port number (e.g.
 *   `http://example.com:8080/api`), it will be respected.
 *
 *   If you are using a url with a suffix, just add the suffix, like this:
 *   `$resource('http://example.com/resource.json')` or `$resource('http://example.com/:id.json')`
 *   or even `$resource('http://example.com/resource/:resource_id.:format')`
 *   If the parameter before the suffix is empty, :resource_id in this case, then the `/.` will be
 *   collapsed down to a single `.`.  If you need this sequence to appear and not collapse then you
 *   can escape it with `/\.`.
 *
 * @param {Object=} paramDefaults Default values for `url` parameters. These can be overridden in
 *   `actions` methods. If any of the parameter value is a function, it will be executed every time
 *   when a param value needs to be obtained for a request (unless the param was overridden).
 *
 *   Each key value in the parameter object is first bound to url template if present and then any
 *   excess keys are appended to the url search query after the `?`.
 *
 *   Given a template `/path/:verb` and parameter `{verb:'greet', salutation:'Hello'}` results in
 *   URL `/path/greet?salutation=Hello`.
 *
 *   If the parameter value is prefixed with `@` then the value for that parameter will be extracted
 *   from the corresponding property on the `data` object (provided when calling an action method).  For
 *   example, if the `defaultParam` object is `{someParam: '@someProp'}` then the value of `someParam`
 *   will be `data.someProp`.
 *
 * @param {Object.<Object>=} actions Hash with declaration of custom actions that should extend
 *   the default set of resource actions. The declaration should be created in the format of {@link
 *   ng.$http#usage $http.config}:
 *
 *       {action1: {method:?, params:?, isArray:?, headers:?, ...},
 *        action2: {method:?, params:?, isArray:?, headers:?, ...},
 *        ...}
 *
 *   Where:
 *
 *   - **`action`** – {string} – The name of action. This name becomes the name of the method on
 *     your resource object.
 *   - **`method`** – {string} – Case insensitive HTTP method (e.g. `GET`, `POST`, `PUT`,
 *     `DELETE`, `JSONP`, etc).
 *   - **`params`** – {Object=} – Optional set of pre-bound parameters for this action. If any of
 *     the parameter value is a function, it will be executed every time when a param value needs to
 *     be obtained for a request (unless the param was overridden).
 *   - **`url`** – {string} – action specific `url` override. The url templating is supported just
 *     like for the resource-level urls.
 *   - **`isArray`** – {boolean=} – If true then the returned object for this action is an array,
 *     see `returns` section.
 *   - **`transformRequest`** –
 *     `{function(data, headersGetter)|Array.<function(data, headersGetter)>}` –
 *     transform function or an array of such functions. The transform function takes the http
 *     request body and headers and returns its transformed (typically serialized) version.
 *     By default, transformRequest will contain one function that checks if the request data is
 *     an object and serializes to using `angular.toJson`. To prevent this behavior, set
 *     `transformRequest` to an empty array: `transformRequest: []`
 *   - **`transformResponse`** –
 *     `{function(data, headersGetter)|Array.<function(data, headersGetter)>}` –
 *     transform function or an array of such functions. The transform function takes the http
 *     response body and headers and returns its transformed (typically deserialized) version.
 *     By default, transformResponse will contain one function that checks if the response looks like
 *     a JSON string and deserializes it using `angular.fromJson`. To prevent this behavior, set
 *     `transformResponse` to an empty array: `transformResponse: []`
 *   - **`cache`** – `{boolean|Cache}` – If true, a default $http cache will be used to cache the
 *     GET request, otherwise if a cache instance built with
 *     {@link ng.$cacheFactory $cacheFactory}, this cache will be used for
 *     caching.
 *   - **`timeout`** – `{number|Promise}` – timeout in milliseconds, or {@link ng.$q promise} that
 *     should abort the request when resolved.
 *   - **`withCredentials`** - `{boolean}` - whether to set the `withCredentials` flag on the
 *     XHR object. See
 *     [requests with credentials](https://developer.mozilla.org/en/http_access_control#section_5)
 *     for more information.
 *   - **`responseType`** - `{string}` - see
 *     [requestType](https://developer.mozilla.org/en-US/docs/DOM/XMLHttpRequest#responseType).
 *   - **`interceptor`** - `{Object=}` - The interceptor object has two optional methods -
 *     `response` and `responseError`. Both `response` and `responseError` interceptors get called
 *     with `http response` object. See {@link ng.$http $http interceptors}.
 *
 * @param {Object} options Hash with custom settings that should extend the
 *   default `$resourceProvider` behavior.  The only supported option is
 *
 *   Where:
 *
 *   - **`stripTrailingSlashes`** – {boolean} – If true then the trailing
 *   slashes from any calculated URL will be stripped. (Defaults to true.)
 *
 * @returns {Object} A resource "class" object with methods for the default set of resource actions
 *   optionally extended with custom `actions`. The default set contains these actions:
 *   ```js
 *   { 'get':    {method:'GET'},
 *     'save':   {method:'POST'},
 *     'query':  {method:'GET', isArray:true},
 *     'remove': {method:'DELETE'},
 *     'delete': {method:'DELETE'} };
 *   ```
 *
 *   Calling these methods invoke an {@link ng.$http} with the specified http method,
 *   destination and parameters. When the data is returned from the server then the object is an
 *   instance of the resource class. The actions `save`, `remove` and `delete` are available on it
 *   as  methods with the `$` prefix. This allows you to easily perform CRUD operations (create,
 *   read, update, delete) on server-side data like this:
 *   ```js
 *   var User = $resource('/user/:userId', {userId:'@id'});
 *   var user = User.get({userId:123}, function() {
 *     user.abc = true;
 *     user.$save();
 *   });
 *   ```
 *
 *   It is important to realize that invoking a $resource object method immediately returns an
 *   empty reference (object or array depending on `isArray`). Once the data is returned from the
 *   server the existing reference is populated with the actual data. This is a useful trick since
 *   usually the resource is assigned to a model which is then rendered by the view. Having an empty
 *   object results in no rendering, once the data arrives from the server then the object is
 *   populated with the data and the view automatically re-renders itself showing the new data. This
 *   means that in most cases one never has to write a callback function for the action methods.
 *
 *   The action methods on the class object or instance object can be invoked with the following
 *   parameters:
 *
 *   - HTTP GET "class" actions: `Resource.action([parameters], [success], [error])`
 *   - non-GET "class" actions: `Resource.action([parameters], postData, [success], [error])`
 *   - non-GET instance actions:  `instance.$action([parameters], [success], [error])`
 *
 *
 *   Success callback is called with (value, responseHeaders) arguments. Error callback is called
 *   with (httpResponse) argument.
 *
 *   Class actions return empty instance (with additional properties below).
 *   Instance actions return promise of the action.
 *
 *   The Resource instances and collection have these additional properties:
 *
 *   - `$promise`: the {@link ng.$q promise} of the original server interaction that created this
 *     instance or collection.
 *
 *     On success, the promise is resolved with the same resource instance or collection object,
 *     updated with data from server. This makes it easy to use in
 *     {@link ngRoute.$routeProvider resolve section of $routeProvider.when()} to defer view
 *     rendering until the resource(s) are loaded.
 *
 *     On failure, the promise is resolved with the {@link ng.$http http response} object, without
 *     the `resource` property.
 *
 *     If an interceptor object was provided, the promise will instead be resolved with the value
 *     returned by the interceptor.
 *
 *   - `$resolved`: `true` after first server interaction is completed (either with success or
 *      rejection), `false` before that. Knowing if the Resource has been resolved is useful in
 *      data-binding.
 *
 * @example
 *
 * # Credit card resource
 *
 * ```js
     // Define CreditCard class
     var CreditCard = $resource('/user/:userId/card/:cardId',
      {userId:123, cardId:'@id'}, {
       charge: {method:'POST', params:{charge:true}}
      });

     // We can retrieve a collection from the server
     var cards = CreditCard.query(function() {
       // GET: /user/123/card
       // server returns: [ {id:456, number:'1234', name:'Smith'} ];

       var card = cards[0];
       // each item is an instance of CreditCard
       expect(card instanceof CreditCard).toEqual(true);
       card.name = "J. Smith";
       // non GET methods are mapped onto the instances
       card.$save();
       // POST: /user/123/card/456 {id:456, number:'1234', name:'J. Smith'}
       // server returns: {id:456, number:'1234', name: 'J. Smith'};

       // our custom method is mapped as well.
       card.$charge({amount:9.99});
       // POST: /user/123/card/456?amount=9.99&charge=true {id:456, number:'1234', name:'J. Smith'}
     });

     // we can create an instance as well
     var newCard = new CreditCard({number:'0123'});
     newCard.name = "Mike Smith";
     newCard.$save();
     // POST: /user/123/card {number:'0123', name:'Mike Smith'}
     // server returns: {id:789, number:'0123', name: 'Mike Smith'};
     expect(newCard.id).toEqual(789);
 * ```
 *
 * The object returned from this function execution is a resource "class" which has "static" method
 * for each action in the definition.
 *
 * Calling these methods invoke `$http` on the `url` template with the given `method`, `params` and
 * `headers`.
 * When the data is returned from the server then the object is an instance of the resource type and
 * all of the non-GET methods are available with `$` prefix. This allows you to easily support CRUD
 * operations (create, read, update, delete) on server-side data.

   ```js
     var User = $resource('/user/:userId', {userId:'@id'});
     User.get({userId:123}, function(user) {
       user.abc = true;
       user.$save();
     });
   ```
 *
 * It's worth noting that the success callback for `get`, `query` and other methods gets passed
 * in the response that came from the server as well as $http header getter function, so one
 * could rewrite the above example and get access to http headers as:
 *
   ```js
     var User = $resource('/user/:userId', {userId:'@id'});
     User.get({userId:123}, function(u, getResponseHeaders){
       u.abc = true;
       u.$save(function(u, putResponseHeaders) {
         //u => saved user object
         //putResponseHeaders => $http header getter
       });
     });
   ```
 *
 * You can also access the raw `$http` promise via the `$promise` property on the object returned
 *
   ```
     var User = $resource('/user/:userId', {userId:'@id'});
     User.get({userId:123})
         .$promise.then(function(user) {
           $scope.user = user;
         });
   ```

 * # Creating a custom 'PUT' request
 * In this example we create a custom method on our resource to make a PUT request
 * ```js
 *    var app = angular.module('app', ['ngResource', 'ngRoute']);
 *
 *    // Some APIs expect a PUT request in the format URL/object/ID
 *    // Here we are creating an 'update' method
 *    app.factory('Notes', ['$resource', function($resource) {
 *    return $resource('/notes/:id', null,
 *        {
 *            'update': { method:'PUT' }
 *        });
 *    }]);
 *
 *    // In our controller we get the ID from the URL using ngRoute and $routeParams
 *    // We pass in $routeParams and our Notes factory along with $scope
 *    app.controller('NotesCtrl', ['$scope', '$routeParams', 'Notes',
                                      function($scope, $routeParams, Notes) {
 *    // First get a note object from the factory
 *    var note = Notes.get({ id:$routeParams.id });
 *    $id = note.id;
 *
 *    // Now call update passing in the ID first then the object you are updating
 *    Notes.update({ id:$id }, note);
 *
 *    // This will PUT /notes/ID with the note object in the request payload
 *    }]);
 * ```
 */
angular.module('ngResource', ['ng']).
  provider('$resource', function() {
    var provider = this;

    this.defaults = {
      // Strip slashes by default
      stripTrailingSlashes: true,

      // Default actions configuration
      actions: {
        'get': {method: 'GET'},
        'save': {method: 'POST'},
        'query': {method: 'GET', isArray: true},
        'remove': {method: 'DELETE'},
        'delete': {method: 'DELETE'}
      }
    };

    this.$get = ['$http', '$q', function($http, $q) {

      var noop = angular.noop,
        forEach = angular.forEach,
        extend = angular.extend,
        copy = angular.copy,
        isFunction = angular.isFunction;

      /**
       * We need our custom method because encodeURIComponent is too aggressive and doesn't follow
       * http://www.ietf.org/rfc/rfc3986.txt with regards to the character set
       * (pchar) allowed in path segments:
       *    segment       = *pchar
       *    pchar         = unreserved / pct-encoded / sub-delims / ":" / "@"
       *    pct-encoded   = "%" HEXDIG HEXDIG
       *    unreserved    = ALPHA / DIGIT / "-" / "." / "_" / "~"
       *    sub-delims    = "!" / "$" / "&" / "'" / "(" / ")"
       *                     / "*" / "+" / "," / ";" / "="
       */
      function encodeUriSegment(val) {
        return encodeUriQuery(val, true).
          replace(/%26/gi, '&').
          replace(/%3D/gi, '=').
          replace(/%2B/gi, '+');
      }


      /**
       * This method is intended for encoding *key* or *value* parts of query component. We need a
       * custom method because encodeURIComponent is too aggressive and encodes stuff that doesn't
       * have to be encoded per http://tools.ietf.org/html/rfc3986:
       *    query       = *( pchar / "/" / "?" )
       *    pchar         = unreserved / pct-encoded / sub-delims / ":" / "@"
       *    unreserved    = ALPHA / DIGIT / "-" / "." / "_" / "~"
       *    pct-encoded   = "%" HEXDIG HEXDIG
       *    sub-delims    = "!" / "$" / "&" / "'" / "(" / ")"
       *                     / "*" / "+" / "," / ";" / "="
       */
      function encodeUriQuery(val, pctEncodeSpaces) {
        return encodeURIComponent(val).
          replace(/%40/gi, '@').
          replace(/%3A/gi, ':').
          replace(/%24/g, '$').
          replace(/%2C/gi, ',').
          replace(/%20/g, (pctEncodeSpaces ? '%20' : '+'));
      }

      function Route(template, defaults) {
        this.template = template;
        this.defaults = extend({}, provider.defaults, defaults);
        this.urlParams = {};
      }

      Route.prototype = {
        setUrlParams: function(config, params, actionUrl) {
          var self = this,
            url = actionUrl || self.template,
            val,
            encodedVal;

          var urlParams = self.urlParams = {};
          forEach(url.split(/\W/), function(param) {
            if (param === 'hasOwnProperty') {
              throw $resourceMinErr('badname', "hasOwnProperty is not a valid parameter name.");
            }
            if (!(new RegExp("^\\d+$").test(param)) && param &&
              (new RegExp("(^|[^\\\\]):" + param + "(\\W|$)").test(url))) {
              urlParams[param] = true;
            }
          });
          url = url.replace(/\\:/g, ':');

          params = params || {};
          forEach(self.urlParams, function(_, urlParam) {
            val = params.hasOwnProperty(urlParam) ? params[urlParam] : self.defaults[urlParam];
            if (angular.isDefined(val) && val !== null) {
              encodedVal = encodeUriSegment(val);
              url = url.replace(new RegExp(":" + urlParam + "(\\W|$)", "g"), function(match, p1) {
                return encodedVal + p1;
              });
            } else {
              url = url.replace(new RegExp("(\/?):" + urlParam + "(\\W|$)", "g"), function(match,
                  leadingSlashes, tail) {
                if (tail.charAt(0) == '/') {
                  return tail;
                } else {
                  return leadingSlashes + tail;
                }
              });
            }
          });

          // strip trailing slashes and set the url (unless this behavior is specifically disabled)
          if (self.defaults.stripTrailingSlashes) {
            url = url.replace(/\/+$/, '') || '/';
          }

          // then replace collapse `/.` if found in the last URL path segment before the query
          // E.g. `http://url.com/id./format?q=x` becomes `http://url.com/id.format?q=x`
          url = url.replace(/\/\.(?=\w+($|\?))/, '.');
          // replace escaped `/\.` with `/.`
          config.url = url.replace(/\/\\\./, '/.');


          // set params - delegate param encoding to $http
          forEach(params, function(value, key) {
            if (!self.urlParams[key]) {
              config.params = config.params || {};
              config.params[key] = value;
            }
          });
        }
      };


      function resourceFactory(url, paramDefaults, actions, options) {
        var route = new Route(url, options);

        actions = extend({}, provider.defaults.actions, actions);

        function extractParams(data, actionParams) {
          var ids = {};
          actionParams = extend({}, paramDefaults, actionParams);
          forEach(actionParams, function(value, key) {
            if (isFunction(value)) { value = value(); }
            ids[key] = value && value.charAt && value.charAt(0) == '@' ?
              lookupDottedPath(data, value.substr(1)) : value;
          });
          return ids;
        }

        function defaultResponseInterceptor(response) {
          return response.resource;
        }

        function Resource(value) {
          shallowClearAndCopy(value || {}, this);
        }

        Resource.prototype.toJSON = function() {
          var data = extend({}, this);
          delete data.$promise;
          delete data.$resolved;
          return data;
        };

        forEach(actions, function(action, name) {
          var hasBody = /^(POST|PUT|PATCH)$/i.test(action.method);

          Resource[name] = function(a1, a2, a3, a4) {
            var params = {}, data, success, error;

            /* jshint -W086 */ /* (purposefully fall through case statements) */
            switch (arguments.length) {
              case 4:
                error = a4;
                success = a3;
              //fallthrough
              case 3:
              case 2:
                if (isFunction(a2)) {
                  if (isFunction(a1)) {
                    success = a1;
                    error = a2;
                    break;
                  }

                  success = a2;
                  error = a3;
                  //fallthrough
                } else {
                  params = a1;
                  data = a2;
                  success = a3;
                  break;
                }
              case 1:
                if (isFunction(a1)) success = a1;
                else if (hasBody) data = a1;
                else params = a1;
                break;
              case 0: break;
              default:
                throw $resourceMinErr('badargs',
                  "Expected up to 4 arguments [params, data, success, error], got {0} arguments",
                  arguments.length);
            }
            /* jshint +W086 */ /* (purposefully fall through case statements) */

            var isInstanceCall = this instanceof Resource;
            var value = isInstanceCall ? data : (action.isArray ? [] : new Resource(data));
            var httpConfig = {};
            var responseInterceptor = action.interceptor && action.interceptor.response ||
              defaultResponseInterceptor;
            var responseErrorInterceptor = action.interceptor && action.interceptor.responseError ||
              undefined;

            forEach(action, function(value, key) {
              if (key != 'params' && key != 'isArray' && key != 'interceptor') {
                httpConfig[key] = copy(value);
              }
            });

            if (hasBody) httpConfig.data = data;
            route.setUrlParams(httpConfig,
              extend({}, extractParams(data, action.params || {}), params),
              action.url);

            var promise = $http(httpConfig).then(function(response) {
              var data = response.data,
                promise = value.$promise;

              if (data) {
                // Need to convert action.isArray to boolean in case it is undefined
                // jshint -W018
                if (angular.isArray(data) !== (!!action.isArray)) {
                  throw $resourceMinErr('badcfg',
                      'Error in resource configuration for action `{0}`. Expected response to ' +
                      'contain an {1} but got an {2} (Request: {3} {4})', name, action.isArray ? 'array' : 'object',
                    angular.isArray(data) ? 'array' : 'object', httpConfig.method, httpConfig.url);
                }
                // jshint +W018
                if (action.isArray) {
                  value.length = 0;
                  forEach(data, function(item) {
                    if (typeof item === "object") {
                      value.push(new Resource(item));
                    } else {
                      // Valid JSON values may be string literals, and these should not be converted
                      // into objects. These items will not have access to the Resource prototype
                      // methods, but unfortunately there
                      value.push(item);
                    }
                  });
                } else {
                  shallowClearAndCopy(data, value);
                  value.$promise = promise;
                }
              }

              value.$resolved = true;

              response.resource = value;

              return response;
            }, function(response) {
              value.$resolved = true;

              (error || noop)(response);

              return $q.reject(response);
            });

            promise = promise.then(
              function(response) {
                var value = responseInterceptor(response);
                (success || noop)(value, response.headers);
                return value;
              },
              responseErrorInterceptor);

            if (!isInstanceCall) {
              // we are creating instance / collection
              // - set the initial promise
              // - return the instance / collection
              value.$promise = promise;
              value.$resolved = false;

              return value;
            }

            // instance call
            return promise;
          };


          Resource.prototype['$' + name] = function(params, success, error) {
            if (isFunction(params)) {
              error = success; success = params; params = {};
            }
            var result = Resource[name].call(this, params, this, success, error);
            return result.$promise || result;
          };
        });

        Resource.bind = function(additionalParamDefaults) {
          return resourceFactory(url, extend({}, paramDefaults, additionalParamDefaults), actions);
        };

        return Resource;
      }

      return resourceFactory;
    }];
  });


})(window, window.angular);
;'use strict';

app
.controller('AdminController', function ($scope, $state, $cookieStore,$stateParams,$filter ) {

	console.log("admin");


	$scope.user = $cookieStore.get('connectedUser');
	 if(!$scope.user )
  {
  	 $state.go('login');
  }
   else if($scope.user.utilisateur.type != 'A')
	{
		$state.go('login');
	}
	else
	{
		$scope.id = $scope.user.utilisateur.id ;
	}
});




;'use strict';

app
.controller('AdminArchiveController', function ($scope, $state,$stateParams,$filter, $cookieStore , Collaborateur ) {

    $scope.user = $cookieStore.get('connectedUser');
     if(!$scope.user )
  {
  	 $state.go('login');
  }
   else if($scope.user.utilisateur.type != 'A')
    {
        $state.go('login');
    }
    else
    {
        $scope.id = $scope.user.utilisateur.id ;
    }
    Collaborateur.get({id : $stateParams.id} , function  (result) {

       $scope.collaborateur = result; 


   });  

    $scope.showObjectifs = function (id) {

        $scope.hideobjectifs=false;

        var fichesobjectif= $scope.collaborateur.fichesobjectifs.filter(function (entity) { return entity.id==id;});

        $scope.fichesobjectif=fichesobjectif[0];

        if($scope.fichesobjectif.objectifs.length==0)$scope.hideobjectifs=true;

        $('#objectifsModal').modal('show');
    };

    $scope.showEvaluations = function (id) {

        $scope.hideevaluations=false;

        var fichesevaluations= $scope.collaborateur.fichesevaluations.filter(function (entity) { return entity.id==id;});

        $scope.fichesevaluation=fichesevaluations[0];

        if($scope.fichesevaluation.evaluations.length==0)$scope.hideevaluations=true;

        $('#evaluationModal').modal('show');
    };


});




;'use strict';

app
.controller('AdminCollaborateurController', function ($scope, $state,$stateParams,$filter , $cookieStore, Collaborateur) {

$scope.user = $cookieStore.get('connectedUser');
	 if(!$scope.user )
  {
  	 $state.go('login');
  }
   else if($scope.user.utilisateur.type != 'A')
	{
		$state.go('login');
	}
	else
	{
		$scope.id = $scope.user.utilisateur.id ;
	}
console.log("admin");
Collaborateur.get({id:$stateParams.id}, function  (result) {
	
	$scope.collaborateur = result;

})


});




;'use strict';

app
.controller('AdminCollaborateursController', function ($scope, $state,$stateParams,$filter ,$cookieStore , Collaborateur , Manager , connect ) {

	console.log("admin collaborateur");
	
  $scope.user = $cookieStore.get('connectedUser');
	 if(!$scope.user )
  {
  	 $state.go('login');
  }
   else if($scope.user.utilisateur.type != 'A')
	{
		$state.go('login');
	}
	else
	{
		$scope.id = $scope.user.utilisateur.id ;
	}

	$scope.managerupdt = {};
	$scope.modif = [];
	$scope.newcollaborateur = {};
	$scope.collaborateurs = Collaborateur.query();
	

	

	$scope.initModif=function (i)
	{	
		$scope.collaborateurs.forEach(function  (collaborateur) {
			collaborateur.motDePasse = "";

		})

		$scope.modif[i] =true;
	}

	$scope.modifier = function  (i,collaborateur) {

		$scope.modif[i] =false;
		Collaborateur.update({id:collaborateur.id},collaborateur);


	}


	$scope.initsupprimer = function  (collaborateur) {

		$scope.collaborateursup = collaborateur;
		$('#suppressionModal').modal('show');                                         
	}


	$scope.supprimer=function  () {
		Collaborateur.delete({id:$scope.collaborateursup.id} , $scope.collaborateursup);
		$('#suppressionModal').modal('hide');                                         
		$scope.collaborateurs = Collaborateur.query();
	}

	
	$scope.ajouter = function  () {
	
		console.log("id manager "+$scope.managerupdt.id+"collaborateur");
		console.log($scope.newcollaborateur);
		 Collaborateur.new({idmanager : $scope.managerupdt.id} ,$scope.newcollaborateur ) ;
		$('#addModal').modal('hide');                                         

	}

	$scope.initajouter = function  () {
		$scope.managers = Manager.query();
		$('#addModal').modal('show');                                         

	}

});




;'use strict';

app
.controller('AdminEncadrantsController', function ($scope, $state,$stateParams,$filter ,$cookieStore, Encadrant ) {

	console.log("admin encadrant");
	$scope.user = $cookieStore.get('connectedUser');
	 if(!$scope.user )
  {
  	 $state.go('login');
  }
   else if($scope.user.utilisateur.type != 'A')
	{
		$state.go('login');
	}
	else
	{
		$scope.id = $scope.user.utilisateur.id ;
	}
	$scope.modif = [];
	$scope.newencadrant = {};
	$scope.encadrants = Encadrant.query();
	

	Encadrant.get({id:161},function  (result) {

		console.log(result);
	})

	$scope.initModif=function (i)
	{	
		$scope.encadrants.forEach(function  (encadrant) {
			encadrant.motDePasse = "";

		})

		$scope.modif[i] =true;
	}

	$scope.modifier = function  (i,encadrant) {

		$scope.modif[i] =false;
		Encadrant.update({id:encadrant.id},encadrant);


	}


	$scope.initsupprimer = function  (encadrant) {

		$scope.encadrantsup = encadrant;
		$('#suppressionModal').modal('show');  

	}


	$scope.supprimer=function  () {
		Encadrant.delete({id:$scope.encadrantsup.id} , $scope.encadrantsup);
		$('#suppressionModal').modal('hide');                                         
		$scope.encadrants = Encadrant.query();
	}


	$scope.ajouter = function  () {

		
		Encadrant.save($scope.newencadrant)
		$('#addModal').modal('hide');                                         

	}

	$scope.initajouter = function  () {
		
		$('#addModal').modal('show');                                         

	}

});




;'use strict';

app
.controller('AdminManagersController', function ($scope, $state,$stateParams,$filter ,$cookieStore, Manager ) {

	console.log("admin manager");
	$scope.user = $cookieStore.get('connectedUser');
	 if(!$scope.user )
  {
  	 $state.go('login');
  }
   else if($scope.user.utilisateur.type != 'A')
	{
		$state.go('login');
	}
	else
	{
		$scope.id = $scope.user.utilisateur.id ;
	}
	$scope.modif = [];
	$scope.newmanager = {};
	$scope.managers = Manager.query();
	

	

	$scope.initModif=function (i)
	{	
		$scope.managers.forEach(function  (manager) {
			manager.motDePasse = "";

		})

		$scope.modif[i] =true;
	}

	$scope.modifier = function  (i,manager) {

		$scope.modif[i] =false;
		Manager.update({id:manager.id},manager);


	}


	$scope.initsupprimer = function  (manager) {

		$scope.managersup = manager;
		$('#suppressionModal').modal('show');                                         
	}


	$scope.supprimer=function  () {
		Manager.delete({id:$scope.managersup.id} , $scope.managersup);
		$('#suppressionModal').modal('hide');                                         
		$scope.managers = Manager.query();
	}


	
	$scope.ajouter = function  () { 
		
		Manager.save($scope.newmanager ) ;
		$('#addModal').modal('hide');                                         
		

	}

	$scope.initajouter = function  () {
		
		$('#addModal').modal('show');                                         

	}



});




;'use strict';

app
    .config(function ($stateProvider) {
        $stateProvider
            .state('administrateur', {
                url: '/admin',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/administrateur/listcollaborateurs.html',
                        controller: 'AdminCollaborateursController'
                    },
                    'navbar@': {
                        templateUrl: 'scripts/app/partials/navbar-a.partial.html'
                    }
                    
                    },
                    
            })
            .state('administrateur.fiches', {
                url: '/fiches/:id',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/administrateur/fiches.html',
                        controller: 'AdminArchiveController'
                    }
                }
            })
            .state('administrateur.collaborateur', {
                url: '/collaborateur/:id',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/administrateur/detailcollaborateur.html',
                        controller: 'AdminCollaborateurController'
                    }
                }
            })
            .state('administrateur.collaborateurs', {
                url: '/collaborateurs',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/administrateur/listcollaborateurs.html',
                        controller: 'AdminCollaborateursController'
                    }
                }
            })
            .state('administrateur.Encadrants', {
                url: '/Encadrants',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/administrateur/listEncadrants.html',
                        controller: 'AdminEncadrantsController'
                    }
                }
            })
            .state('administrateur.Managers', {
                url: '/Managers',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/administrateur/listManagers.html',
                        controller: 'AdminManagersController'
                    }
                }
            });
            
    });
;'use strict';

app
.controller('CollaborateurController', function ($scope, $stateParams,$filter, Collaborateur , $cookieStore,$state ,Objectif, Utilisateur , Bap) {
    console.log("Testing the rest API");

    $scope.user = $cookieStore.get('connectedUser');
     if(!$scope.user )
  {
  	 $state.go('login');
  }
   else if($scope.user.utilisateur.type != 'C')
    {
       $state.go('login');
   }
   else
   {
    $scope.id = $scope.user.utilisateur.id ;
   }
   Collaborateur.get({id: $scope.id}, function(result) {
    $scope.collaborateur = result;
    $scope.collaborateur.fichesobjectifs= $scope.collaborateur.fichesobjectifs.filter(function (entity) { return entity.autorisationAcces==1;});
    $scope.collaborateur.fichesevaluations= $scope.collaborateur.fichesevaluations.filter(function (entity) { return entity.autorisationAcces==1;});

});  

   $scope.currentfiche =Objectif.currentfiche({id:$scope.id});

   Bap.bapByStatut({id:$scope.id, statut : "A_VALIDER"},function(result)
   {
    $scope.bap =result;
    $scope.ficheEnAttente = result.ficheObjectifsRediges;        
});


   $scope.loadAll=function  () {
    $scope.collaborateurs = Collaborateur.query();

}
$scope.valider =function ()
{

    console.log($scope.bap);
    Bap.valider($scope.bap);
}

$scope.rejeter =function ()
{
   
    console.log($scope.bap);
    Bap.rejeter($scope.bap);
}
$scope.showObjectifs = function (id) {
    $scope.hideobjectifs=false;
    var fichesobjectif= $scope.collaborateur.fichesobjectifs.filter(function (entity) { return entity.id==id;});
    $scope.fichesobjectif=fichesobjectif[0];
    if($scope.fichesobjectif.objectifs.length==0)$scope.hideobjectifs=true;
    $('#objectifsModal').modal('show');
};
$scope.showEvaluations = function (id) {
    $scope.hidevaluations=false;
    var fichesevaluation= $scope.collaborateur.fichesevaluations.filter(function (entity) { return entity.id==id;});
    $scope.fichesevaluation=fichesevaluation[0];
    if($scope.fichesevaluation.evaluations.length==0)$scope.hidevaluations=true;
    $('#evaluationModal').modal('show');
};

});
;'use strict';

app
    .config(function ($stateProvider) {
        $stateProvider
            .state('test', {
                url: '/tests',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/collaborateur/test.html',
                        controller: 'TestController'
                    }
                }
            })
            .state('collaborateur', {
                url: '/collaborateurs',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/collaborateur/collaborateur.html',
                        controller: 'CollaborateurController'
                    },
                    'navbar@': {
                        templateUrl: 'scripts/app/partials/navbar-c.partial.html'
                    }
                    
                    }

                
            })
            .state('collaborateur.fichesobjectifs', {
                url: '/collaborateurs/fichesobjectifs',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/collaborateur/fichesobjectifs.html',
                        controller: 'CollaborateurController'
                    }
                }
            })
            .state('collaborateur.fichesevaluation', {
                url: '/collaborateurs/fichesevaluation',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/collaborateur/fichesevaluation.html',
                        controller: 'CollaborateurController'
                    }
                }
            });
            
    });
;'use strict';

app
    .controller('TestController', function ($scope, $stateParams,$filter ,Encadrant) {
        console.log("Testing the rest API");
         
         // Put/Post errors
                //collaborateur+encadrant+feedback+manager put,Post :Unrecognized field "autoformation" (Class com.echallenge.model.PlanAmelioration), not marked as ignorable
                //Bap Validé 
                //put,Post action {
                                // idcollaborateur cannot be null ?!
                                // }

                   // put , Post Bip :
                    // Unrecognized field "collaborateur" (Class com.echallenge.model.BIP),
                     // not marked as ignorable

        //Post , put Evaluation :idEncadrant cannot be null        
        //Post , put Formation : idCollaborateur cannot be null        
                
                

                Encadrant.get({id:149},function (result) {
                    
                   
                    console.log(result);
                    
                    result.evaluations[0].poids=-1;
                    Encadrant.update({id:149},result);


                    

                    // Formation.save(result);



                });
                
    
         
    });
;'use strict';

app
.controller('EncadrantCollaborateurController', function ($scope, $state,$stateParams,$filter , Bap ,DemandeBip ,Feedback ,$cookieStore, Collaborateur , Encadrant ) {


  $scope.user = $cookieStore.get('connectedUser');
   if($scope.user.utilisateur.type != 'E')
   {
     $state.go('login');
 }
 else
 {
    $scope.id = $scope.user.utilisateur.id ;
}


    $scope.modif = [];
    $scope.feedback = {};
    $scope.feedback.qualificationstheme =[];
    $scope.newqualification={};
    $scope.encadrant = Encadrant.get({id:$scope.id});
    Bap.bapCourant({id:$stateParams.id},function  (result) {

        $scope.bap=result;
        console.log($scope.encadrant);

    });




    
    $scope.initdemandeBip = function  (collaborateur) {
            // afficher modal
            $scope.collaborateurdemande = collaborateur ; 
            console.log(collaborateur);
            $('#demandeBipModal').modal('show');
            console.log($scope.encadrant);
        }

        $scope.demandeBip = function  (collaborateur) {
            // save demandeBip
            console.log("demande bip confirmé ...");
            var demandeBip = {};
            demandeBip.collaborateur= collaborateur ;
            demandeBip.dateDemande = new Date();
            demandeBip.encadrant = $scope.encadrant;

            DemandeBip.save(demandeBip)   ;
            $('#demandeBipModal').modal('hide');             
        }

        $scope.evaluer= function  (collaborateur) {

            Bap.update({id:$scope.bap.id} , $scope.bap);


        }
        $scope.initEvaluation = function  () {


            $('#evaluationModal').modal('show');             

        }
        $scope.initFeedBack =function  () {
            $('#feedbackModal').modal('show');                                         
        }

        $scope.feedBack= function  () {
            $scope.feedback.encadrant =$scope.encadrant ; 
            $scope.feedback.entete.dateDebutIntervention = new Date($scope.feedback.entete.dateDebutIntervention );
            $scope.feedback.entete.dateFinIntervention = new Date($scope.feedback.entete.dateFinIntervention );
            console.log($scope.feedback);
            Feedback.save($scope.feedback);

        }

        $scope.addqualification=function  () {
            $scope.feedback.qualificationstheme.push( $scope.newqualification);
            $scope.newqualification={};
        }

        $scope.supprimerQualification=function  (i) {
            $scope.feedback.qualificationstheme.splice(i,1);

        }
        
        $scope.initModif=function (i)
        {

            $scope.modif[i] =true;
        }

        $scope.Modif = function  (i) {
         $scope.modif[i] =false; 
     }


 });

;'use strict';

app
.controller('EncadrantController', function ($scope,$stateParams,$filter , Manager ,$cookieStore,$state , Encadrant,Bap , Collaborateur , DemandeBip) {


   $scope.user = $cookieStore.get('connectedUser');
   if($scope.user.utilisateur.type != 'E')
   {
     $state.go('login');
 }
 else
 {
    $scope.id = $scope.user.utilisateur.id ;
}


$scope.encadrant = Encadrant.get({id:$scope.id});

Collaborateur.encadrant({id:$scope.id},function  (result) {

 $scope.collaborateurs=result;
})        

$scope.initdemandeBip = function  (collaborateur) {
            // afficher modal
            $scope.collaborateurdemande = collaborateur ; 

            $('#demandeBipModal').modal('show');

        }

        $scope.demandeBip = function  (collaborateur) {
            // save demandeBip
            console.log("demande bip confirmé ...");
            var demandeBip = {};
            demandeBip.collaborateur= collaborateur ;
            demandeBip.dateDemande = new Date();
            demandeBip.encadrant = $scope.encadrant;

            DemandeBip.save(demandeBip)   ;
            $('#demandeBipModal').modal('hide');             
        }

        $scope.evaluer= function  (collaborateur) {
        // lancer l'evaluation 
        // 1 selectionner l'objectif  à evaluer du collaborateur encadré
        // 2 evaluer => resultat


    }

    $scope.class = function  (bap) {
        if(bap.statut=="EN_COURS") return  "info";
        if(bap.statut=="EN_ATTENTE") return "warning";
        if(bap.statut=="VALIDE") return "primary";
        if(bap.statut=="REJETE") return "danger";
    }

});




;'use strict';

app
    .config(function ($stateProvider) {
        $stateProvider
            .state('encadrant', {
                url: '/encadrants',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/encadrant/encadrant.html',
                        controller: 'EncadrantController'
                    },
                    'navbar@': {
                        templateUrl: 'scripts/app/partials/navbar-e.partial.html'
                    }
                    
                    }

                
            })
            .state('encadrant.fiches', {
                url: '/fiches/:id',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/encadrant/fiches.html',
                        controller: 'EncadrantArchiveController'
                    }
                }
            })
            .state('encadrant.collaborateur', {
                url: '/collaborateur/:id',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/encadrant/detailcollaborateur.html',
                        controller: 'EncadrantCollaborateurController'
                    }
                }
            })
            .state('encadrant.collaborateurs', {
                url: '/collaborateurs',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/encadrant/listcollaborateurs.html',
                        controller: 'EncadrantCollaborateursController'
                    }
                }
            });
            
    });
;'use strict';

app
.controller('ManagerBipController', function ($scope, $stateParams,$filter , Collaborateur , $cookieStore,$state,Objectif , Bip ) {


  $scope.user = $cookieStore.get('connectedUser');
   if(!$scope.user )
  {
  	 $state.go('login');
  }
   else if($scope.user.utilisateur.type != 'M')
  {
   $state.go('login');
 }
 else
 {
  $scope.id = $scope.user.utilisateur.id ;
}

$scope.modif = [];
$scope.modif2 = [];
$scope.modif3 = [];
$scope.Actions =[]  ;
$scope.objectifsFormation ={};
$scope.objectifsFormation.objectifs =[];
$scope.objectifsFormation.autoformation=false;
$scope.Formations = [];

$scope.newobjectifnewobjectifFormation ={};
Collaborateur.get({id:$stateParams.id},function  (result) {

  $scope.collaborateur=result;
  
  Objectif.ficheEnCours({id:$scope.collaborateur.id},function  (result2) {

    $scope.ficheCourant = result2;
    console.log($scope.ficheCourant);
  })

});


$scope.addObjectif=function  () {
  $scope.ficheCourant.objectifs.push($scope.newobjectif);
  $scope.newobjectif={};
}

$scope.addObjectifFormation=function  () {
  $scope.newobjectifnewobjectifFormation.avancementObjectif = 0 ;
  $scope.objectifsFormation.objectifs.push( $scope.newobjectifnewobjectifFormation);
  
  console.log($scope.objectifsFormation);
  $scope.newobjectifnewobjectifFormation={};
}
$scope.addAction=function  () {
  $scope.Actions.push( $scope.newaction);
  $scope.newaction={};
}

$scope.supprimerAction=function  (i) {
  $scope.Actions.splice(i,1);

}
$scope.supprimerObjectif=function  (i) {
  $scope.ficheCourant.objectifs.splice(i,1);

}
$scope.supprimerObjectifFormation=function  (i) {
  $scope.objectifsFormation.splice(i,1);

}
$scope.initModif=function (i)
{

  $scope.modif[i] =true;
}

$scope.Modif = function  (i) {
 $scope.modif[i] =false; 
}

$scope.initModif2=function (i)
{

  $scope.modif2[i] =true;
}

$scope.Modif2 = function  (i) {
 $scope.modif2[i] =false; 
}

$scope.initModif3=function (i)
{

  $scope.modif3[i] =true;
}

$scope.Modif3 = function  (i) {
 $scope.modif3[i] =false; 
}


$scope.initFormation = function  () {
 $('#FormationModal').modal('show');
}

$scope.initAction = function  () {
 $('#ActionModal').modal('show'); 
}

$scope.MAJFormation = function  () {

  $scope.Formations.push($scope.objectifsFormation);
  $scope.objectifsFormation = {} ;
  $scope.objectifsFormation.objectifs =[];
  $scope.objectifsFormation.autoformation=false;
  $('#FormationModal').modal('hide');    


}
$scope.MAJAction = function  () {

  $('#ActionModal').modal('hide');    
}

$scope.saveBip = function  () {
  
  var bip = {};
  bip.ficheObjectifsTraites = $scope.ficheCourant ; 
  bip.collaborateur = $scope.collaborateur ; 
  bip.actions = $scope.Actions  ;
  bip.formations = $scope.Formations ;
  bip.dateBilan = new Date();
  console.log(bip);

  Bip.save(bip);
  
}


});


;'use strict';

app
.controller('demandeBipsController', function ($scope, $stateParams,$filter , Manager ,$cookieStore,$state , DemandeBip ) {

	
  $scope.user = $cookieStore.get('connectedUser');
    if(!$scope.user )
  {
  	 $state.go('login');
  }
   else if($scope.user.utilisateur.type != 'M')
   {
     $state.go('login');
 }
 else
 {
    $scope.id = $scope.user.utilisateur.id ;
}


Manager.get({id : $scope.id}, function  (result) {
$scope.collaborateurs = result.collaborateurs;
    
});

DemandeBip.collaborateur({id : $scope.id}, function  (result) {
	$scope.demandes = result;
	console.log(result);
})


});

;'use strict';

app
.controller('ManagerController', function ($scope,$stateParams,$filter , Manager ,$cookieStore,$state, Bap , Collaborateur) {

  $scope.user = $cookieStore.get('connectedUser');
    if(!$scope.user )
  {
  	 $state.go('login');
  }
   else if($scope.user.utilisateur.type != 'M')
   {
     $state.go('login');
 }
 else
 {
    $scope.id = $scope.user.utilisateur.id ;
}




       Manager.get({id: $scope.id}, function(result) {
            $scope.manager = result;
            //collaborateurs du managerRH avec un BAp statut en cours
            $scope.collaborateurs = $scope.manager.collaborateurs;        
            });
    
        $scope.class = function  (bap) {
            if(bap.statut=="EN_COURS") return  "info";
            if(bap.statut=="EN_ATTENTE") return "warning";
            if(bap.statut=="VALIDE") return "primary";
            if(bap.statut=="REJETE") return "danger";
        }

    });

;'use strict';

app
    .config(function ($stateProvider) {
        $stateProvider
            .state('manager', {
                url: '/managers',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/manager/listcollaborateurs.html',
                        controller: 'ManagerCollaborateursController'
                    },
                    'navbar@': {
                        templateUrl: 'scripts/app/partials/navbar-m.partial.html'
                    }
                    
                    }

                
            })
            .state('manager.fiches', {
                url: '/fiches/:id',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/manager/fiches.html',
                        controller: 'ManagerArchiveController'
                    }
                }
            })
            .state('manager.demandesbip', {
                url: '/demandesbip',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/manager/demandes.html',
                        controller: 'demandeBipsController'
                    }
                }
            })
            
            .state('manager.collaborateur', {
                url: '/collaborateur/:id',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/manager/detailcollaborateur.html',
                        controller: 'ManagerCollaborateurController'
                    }
                }
            })
            .state('manager.bip', {
                url: '/bip/:id',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/manager/bipcollaborateur.html',
                        controller: 'ManagerBipController'
                    }
                }
            })
            .state('manager.collaborateurs', {
                url: '/collaborateurs',
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/entities/manager/listcollaborateurs.html',
                        controller: 'ManagerCollaborateursController'
                    }
                }
            });
            
    });
;'use strict';

app
.controller('ManagerArchiveController', function ($scope, $stateParams,$filter  ,$cookieStore,$state, Collaborateur) {

  $scope.user = $cookieStore.get('connectedUser');
   if(!$scope.user )
  {
  	 $state.go('login');
  }
   else if($scope.user.utilisateur.type != 'M')
  {
   $state.go('login');
}
else
{
    $scope.id = $scope.user.utilisateur.id ;
}


        //recupérer les fiches du  collaborateur selectionné

        Collaborateur.get({id: $stateParams.id}, function(result) {

            $scope.collaborateur = result;
            
            console.log(result);

            $scope.collaborateur.fichesobjectifs.forEach(function (entity) {

                entity.dateFicheObjectifs = $filter('date')(entity.dateFicheObjectifs, 'yyyy-MM-dd');    

            });
            
            $scope.collaborateur.fichesevaluations.forEach(function (entity) {

                entity.dateEvaluation = $filter('date')(entity.dateEvaluation, 'yyyy-MM-dd');    

            });

        });  

        $scope.showObjectifs = function (id) {

            $scope.hideobjectifs=false;

            var fichesobjectif= $scope.collaborateur.fichesobjectifs.filter(function (entity) { return entity.id==id;});

            $scope.fichesobjectif=fichesobjectif[0];

            if($scope.fichesobjectif.objectifs.length==0)$scope.hideobjectifs=true;

            $('#objectifsModal').modal('show');
        };

        $scope.showEvaluations = function (id) {

            $scope.hideevaluations=false;

            var fichesevaluations= $scope.collaborateur.fichesevaluations.filter(function (entity) { return entity.id==id;});

            $scope.fichesevaluation=fichesevaluations[0];

            if($scope.fichesevaluation.evaluations.length==0)$scope.hideevaluations=true;

            $('#evaluationModal').modal('show');
        };



    });

;'use strict';

app
.controller('ManagerCollaborateurController', function ($scope, $stateParams,$filter , Bap  , Objectif ,Encadrant , Feedback , $cookieStore,$state,Collaborateur) {


  $scope.user = $cookieStore.get('connectedUser');
  
   if(!$scope.user )
  {
  	 $state.go('login');
  }
   else if($scope.user.utilisateur.type != 'M')
  {
   $state.go('login');
 }
 else
 {
  $scope.id = $scope.user.utilisateur.id ;
}

$scope.modif = [];
Bap.bapCourant({id:$stateParams.id},function  (result) {

  $scope.bap=result;
  console.log(result);

});




$scope.initModif=function (i)
{

  $scope.modif[i] =true;
}

$scope.Modif = function  (i) {
 $scope.modif[i] =false; 
}
$scope.initValiderBap = function  (bap) {


  $scope.bapToValidate = bap;

  $scope.totalaValider = 0
  $scope.bapToValidate.ficheEvaluations.evaluations.forEach(function (obje) {

    if(obje.poids != '' )$scope.totalaValider+=parseInt(obje.poids); 
  });

  $scope.bapToValidate.feedbacks.forEach(function (f) {

    var q = Feedback.qualificationglobale({id : f.id}); 
    f.qualificationglobal = q ;
  });


  $scope.current = 1;
  $('#step1_1').show();	
  $('#step1_2').hide();	
  $('#step1_3').hide();	
  $('#step1_4').hide(); 
  $('#step1_5').hide(); 
  $('#BapModal').modal('show');

}


$scope.valider=function  (o,i) {
        // $('#objectif'+o.id).hide();

        $scope.bapToValidate.ficheObjectifsRediges.objectifs.splice(i,1);

        $scope.bapToValidate.ficheObjectifsTraites.objectifs.push(o);

        $('#objectif'+o.id).html("objectif Validé");

      }

      $scope.reporter=function  (o) {

       $('#objectif'+o.id).html("objectif Reporté");
     }

     $scope.nextStep=function()
     {
      if($scope.current==2)
      {
            //valider bap 
            $scope.ValiderBap();
            console.log($scope.bapToValidate);
          }
          if($scope.current==3)console.log($scope.bapToValidate);

          $('#step1_'+$scope.current).hide();
          $scope.current++;
          $('#step1_'+$scope.current).show();
        	// if($scope.current==3)$('#nextbtn').hide();	
        }



        $scope.addObjectif=function  () {
        	$scope.bapToValidate.ficheObjectifsRediges.objectifs.push($scope.newobjectif);
        	$scope.newobjectif={};
        }


        $scope.supprimerObjectif=function  (i) {
        	$scope.bapToValidate.ficheObjectifsRediges.objectifs.splice(i,1);
        }

        $scope.ValiderBap=function()
        {
          $scope.totalaValider = 0
          $scope.bapToValidate.ficheEvaluations.evaluations.forEach(function (obje) {
            $scope.totalaValider+=parseInt(obje.poids); 
          });
          if($scope.totalaValider!=100)
          {
            $scope.error2=true;
          }
          else
          {

            Bap.valider($scope.bapToValidate,function  (result) {
              console.log(result);
              $scope.bapToValidate = result;
            });

          }



        }




        $scope.initPreparerBap = function  (bap) {

         $scope.bapToPrepare = bap;

         $scope.current = 1;
         $('#step2_2').hide();   
         $('#step2_3').hide();   
         $('#step2_1').show();   
         $('#BapModal2').modal('show');

         $scope.total = 0
         $scope.bapToPrepare.ficheEvaluations.evaluations.forEach(function (obje) {

          $scope.total+=parseInt(obje.poids); 
        });


       }
       $scope.majPoid = function  () {
         $scope.total = 0
         $scope.bapToPrepare.ficheEvaluations.evaluations.forEach(function (obje) {

          if(obje.poids != '' )$scope.total+=parseInt(obje.poids); 
        });
       }
       $scope.majPoidaValider = function  () {
         $scope.totalaValider = 0
         $scope.bapToValidate.ficheEvaluations.evaluations.forEach(function (obje) {

          if(obje.poids != '' )$scope.totalaValider+=parseInt(obje.poids); 
        });
       }

       $scope.MAJBap = function  () {
        $scope.total = 0
        $scope.bapToPrepare.ficheEvaluations.evaluations.forEach(function (obje) {
          $scope.total+=parseInt(obje.poids); 
        });
        if($scope.total!=100)
        {
          $scope.error=true;
        }
        else
        {

          Bap.update({id :$scope.bapToPrepare } , $scope.bapToPrepare);
          $('#BapModal2').modal('hide');
        }
      }


      $scope.SaveBap = function  () {
        console.log($scope.bapToValidate);
        Bap.save($scope.bapToValidate,function  (result) {

          $scope.newBap = result;

          $scope.objectifsToLink = $scope.newBap.ficheObjectifsRediges.objectifs;
          $scope.encadrants =Encadrant.query();
          
        });
        
        

        $('#step1_'+$scope.current).hide();
        $scope.current++;
        $('#step1_'+$scope.current).show();
      }

      $scope.initLinkObject = function  (objectif ,encadrant) {
        objectif.encadrant = encadrant;
        console.log($scope.objectifsToLink);
      }

      $scope.LinkObjcetif =function  () {
       $scope.objectifsToLink.forEach(function(objectif) {

         console.log("linking objectif id "+objectif.id+" to encadrant id "+objectif.encadrant.id+"..." );
         Objectif.linkToEncadrant({idObjectif : objectif.id , idencadrant : objectif.encadrant.id });

       }); 
     }

   });

;'use strict';

app
.controller('ManagerCollaborateursController', function ($scope, $stateParams,$filter , Manager ,$cookieStore,$state) {

	
  $scope.user = $cookieStore.get('connectedUser');
  if(!$scope.user )
  {
  	 $state.go('login');
  }
   else if($scope.user.utilisateur.type != 'M')
   {
     $state.go('login');
 }
 else
 {
    $scope.id = $scope.user.utilisateur.id ;
}

Manager.get({id : $scope.id}, function  (result) {
$scope.collaborateurs = result.collaborateurs;
    
});


});

;'use strict';

app
.controller('UtilisateurController', function ($scope, $stateParams, Utilisateur , $rootScope ,$cookieStore , $state) {
    $scope.user = {};
    $scope.login = function  () {
        Utilisateur.auth({email : $scope.user.email , mdp : $scope.user.motDePasse} ,function  (result) {

            if(result.token) 
            {
             
                 $cookieStore.put('connectedUser', result);
                 $cookieStore.put('logged', true);
                 $scope.user = $cookieStore.get('connectedUser');
                if($scope.user.utilisateur.type == 'A')
                {
                 $state.go('administrateur');
                 }
                 if($scope.user.utilisateur.type == 'C')
                {
                 $state.go('collaborateur');
                 }
                 if($scope.user.utilisateur.type == 'E')
                {
                 $state.go('encadrant');
                 }
                 if($scope.user.utilisateur.type == 'M')
                {
                 $state.go('manager');
                 }
           }
           else
           {
            $cookieStore.put('logged', false);
        }

        $scope.$on('handleBroadcast', function() {
        $scope.message = sharedService.message;
    });

    });
    }        

});
;'use strict';

app
    .config(function ($stateProvider) {
        $stateProvider
            .state('login', {
                url: '/login',
                views: {
                    'login@': {
                        templateUrl: 'scripts/app/entities/utilisateur/utilisateur.html',
                        controller: 'UtilisateurController'
                    }
                
                },
                data: {
                    logged : false 
                },
            });
            
    });
;app.directive('navbar', function () {
return {
	restrict: 'A',
        scope: {
            navbar: '='
        },
    templateUrl: function(elem, attr){
    	 

      return 'scripts/app/partials/navbar-'+"c"+'.partial.html';
    
      
    }
  };
});'use strict';

app
    .factory('Action', function ($resource, $filter) {
        
        return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/actions/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'collaborateur' : { 
                        method: 'GET',
                        isArray: true,
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/actions/collaborateur/:id'
                      },
            
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });
;    'use strict';

    app
    .factory('Bap', function ($resource, $filter) {

        return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/baps/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false,
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    data.dateBilan = $filter('date')(data.dateBilan, 'yyyy-MM-dd');    
                    return data;  }  
                },
                'collaborateur' : { 
                    method: 'GET',
                    isArray : true,
                    transformResponse: function (data) {
                        data = angular.fromJson(data);
                        data.dateBilan = $filter('date')(data.dateBilan, 'yyyy-MM-dd');    
                        return data;},
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/baps/collaborateur/:id'
                    },
                    'bapByStatut' :
                    {
                     method: 'GET',
                     url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/baps/collaborateur/statut/:id/:statut'
                 },
                 'bapCourant' :
                 {
                     method: 'GET',
                     transformResponse: function (data) {
                        data = angular.fromJson(data);
                        data.dateBilan = $filter('date')(data.dateBilan, 'yyyy-MM-dd');    
                        return data;},
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/baps/collaborateur/statut/:id/EN_COURS'
                    },
                    'valider' : {
                        method : 'POST',
                        isArray:false,
                        url :'http://localhost:8080/HRPerformanceManagementSystem/resources/baps/valider'
                    },
                    'rejeter' : {
                        method : 'POST',
                        isArray:false,
                        url :'http://localhost:8080/HRPerformanceManagementSystem/resources/baps/rejeter'
                    },
                    'update': { method:'PUT' },
                    'save': { method:'POST' }
                });
});
;'use strict';

app
    .factory('Bip', function ($resource, $filter) {
        
        return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/bips/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false,
                transformResponse: function (data) {
                data = angular.fromJson(data);
                data.dateBilan = $filter('date')(data.dateBilan, 'yyyy-MM-dd');    
                return data;}
            },
            'collaborateur' : { 
                        method: 'GET',
                        isArray: true,
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/bips/collaborateur/:id'
                      },
            
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });
;'use strict';

app
.factory('Collaborateur', function ($resource, $filter) {
    return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/collaborateurs/:id', {}, {
        'query': { method: 'GET', isArray: true},
        'get': {
            method: 'GET',

            transformResponse: function (data) {
                data = angular.fromJson(data);
                data.fichesobjectifs.forEach(function (entity) {
                    entity.dateFicheObjectifs = $filter('date')(entity.dateFicheObjectifs, 'yyyy-MM-dd');    

                });
                data.fichesevaluations.forEach(function (entity) {
                entity.dateEvaluation = $filter('date')(entity.dateEvaluation, 'yyyy-MM-dd');    
            });
                return data;
            }
        },
        'encadrant' : { 
            method: 'GET',
            isArray: true,
            url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/collaborateurs/encadrant/:id'
        },
        'manager' : { 
            method: 'GET',
            isArray: true,
            url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/collaborateurs/managerrh/:id'
        },

        'new' : { 
            method: 'POST', 
            url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/collaborateurs/:idmanager'
        },

        'bap' : { 
            method: 'GET',
            isArray: true,
            url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/collaborateurs/bapstatut/:idencadrant/:statut'
        },
        'update': { method:'PUT' },

        'save': { method:'POST' }
    });
});
;app.service('connect', function () {
        var property ='none' ;

        return {
            getProperty: function () {
                return property;
            },
            setProperty: function(value) {
                property = value;
            }
        };
    });;    'use strict';

    app
    .factory('DemandeBip', function ($resource, $filter) {

        return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/demandebips/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'collaborateur' : { 
                method: 'GET',
                isArray : true,
                url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/demandebips/collaborateur/:id'
            },
            'manager' : { 
                method: 'GET',
                isArray : true,
                url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/demandebips/manager/:id'
            },
            'encadrant' :
            {
               method: 'GET',
               url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/demandebips/encadrant/:id'
           },
           'update': { method:'PUT' },
           'save': { method:'POST' }
       });
    });
;'use strict';

app
    .factory('Encadrant', function ($resource, $filter) {
        
        return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/encadrants/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });
;'use strict';

app
    .factory('Entete', function ($resource, $filter) {
        
        return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/entetes/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'feedback':{method : 'GET',url:'http://localhost:8080/HRPerformanceManagementSystem/resources/entetes/feedback/:id'},
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });
; 'use strict';

app
    .factory('Evaluation', function ($resource, $filter) {
        return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/evaluations/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'ficheCouranteByCollaborateur' : { 
                        method: 'GET',
                        isArray: true,
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/evaluations/ficheevaluationscourantes/collaborateur/:id'
                      },
            'collaborateur' : { 
                        method: 'GET',
                        isArray: true,
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/evaluations/ficheevaluations/collaborateur/:id'
                      },
            'linkObjectifToProjet' : { 
                        method: 'GET',
                        isArray: true,
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/evaluations/ficheevaluation/:idevaluation/:idficheevaluations'
                      },
            'addFiche' : { 
                        method: 'POST',
                        isArray: true,
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/evaluations/ficheevaluations'
                      },
            'updateFiche' : { 
                        method: 'PUT',
                        isArray: true,
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/evaluations/ficheevaluations/:id'
                      },
            'deleteFiche' : { 
                        method: 'DELETE',
                        isArray: true,
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/evaluations/ficheevaluations/:id'
                      },
            'update': { method:'PUT' },
            
            'save': { method:'POST' }
        });
    });
;'use strict';

app
    .factory('Feedback', function ($resource, $filter) {
        return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/feedbacks/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'encadrant' : { 
                        method: 'GET',
                        isArray: true,
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/feedbacks/encadrant/:id'
                      },
            'collaborateur' : { 
                        method: 'GET',
                        isArray: true,
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/feedbacks/collaborateur/:id'
                      },
            
            'qualificationglobale' : { 
                        method: 'GET',
                        isArray: false,
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/feedbacks/qualificationglobale/:id'
                      },
            'bap' : { 
                        method: 'GET',
                        isArray: true,
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/feedbacks/bap/:id'
                      },
            'update': { method:'PUT' },
            
            'save': { method:'POST' }
        });
    });
;'use strict';

app
    .factory('Formation', function ($resource, $filter) {
        
        return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/formations/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'collaborateur' : { 
                        method: 'GET',
                        isArray: true,
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/formations/collaborateur/:id'
                      },
            
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });
;'use strict';

app
    .factory('Manager', function ($resource, $filter) {
        
        return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/managersrh/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });
;'use strict';

app
.factory('Objectif', function ($resource, $filter) {
  return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/objectifs/:id', {}, {
    'query': { method: 'GET', isArray: true},
    'get': {
      method: 'GET',
      transformResponse: function (data) {
        data = angular.fromJson(data);
        return data;
      }
    },
    'update': { method:'PUT' },
    'currentfiche': { 
      method: 'GET',
      isArray: false,

      url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/objectifs/ficheobjectifscourants/collaborateur/:id'
    },
    'ficheEnCours' : {
      method :'GET',
      isArray : false,
      url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/objectifs/ficheobjectifs/encours/:id'
    },

    'collaborateur': { 
      method: 'GET',
      isArray: false,

      url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/objectifs/ficheobjectifs/collaborateur/:id'
    },
    'linkToFiche':
    { 
      method: 'GET',
      isArray: false,
      url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/objectifs/link/ficheobjectifs/:idobjectif/:idficheobjectif'
    },
    'linkToFormation':
    { 
      method: 'GET',
      isArray: false,
      url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/objectifs/link/formation/:idobjectif/:idformation'
    },
    'linkToEncadrant':
    {
      method: 'GET',
      isArray: false,
      url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/objectifs/link/encadrant/:idObjectif/:idencadrant'
    },
    'linkToProject':
    { 
      method: 'GET',
      isArray: false,
      url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/objectifs/link/projet/:idobjectif/:idprojet'
    },

    'addFiche':
    { 
      method: 'POST',
      url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/objectifs/ficheobjectifs'
    },
    'updateFiche':
    { 
      method: 'PUT',
      url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/objectifs/ficheobjectifs/:id'
    },
    'deleteFiche':
    { 
      method: 'DELETE',
      url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/objectifs/ficheobjectifs/:id'
    },
    'save': { method:'POST' }
  });
});
;'use strict';

app
    .factory('Profil', function ($resource, $filter) {
        
        return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/profils/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'code':
                    {  
                        method:'GET',
                        url:'http://localhost:8080/HRPerformanceManagementSystem/resources/profils/bycode/:code'

                    },
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });
;'use strict';

app
    .factory('Projet', function ($resource, $filter) {
        
        return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/<projets></projets>/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                isArray : false
            },
            'code':
                    {  
                        method:'GET',
                        url:'http://localhost:8080/HRPerformanceManagementSystem/resources/profils/bycode/:code'

                    },
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });
;'use strict';

app
    .factory('Utilisateur', function ($resource, $filter) {
        
        return $resource('http://localhost:8080/HRPerformanceManagementSystem/resources/utilisateurs/:id', {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    return data;
                }
            },
            'auth' : { 
                        method: 'GET',
                        isArray: false,
                        url: 'http://localhost:8080/HRPerformanceManagementSystem/resources/utilisateurs/auth/:email/:mdp'
                      },
            'update': { method:'PUT' },
            'save': { method:'POST' }
        });
    });
