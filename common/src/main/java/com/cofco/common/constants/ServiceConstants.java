package com.cofco.common.constants;

public class ServiceConstants {

    public class Paths {

        /**
         * PUBLIC PATHS.
         */
        public static final String GROUP_APP = "Application";
        public static final String PUBLIC = "public";
        public static final String WS_APP = "app";
        public static final String GROUP_AUTH = "Authentication";
        public static final String WS_AUTH = "ws_auth";
        public static final String GROUP_AUTH_DESC = "Operations about user Authentication";

        /**
         * PRIVATE PATHS.
         */
        public static final String PRIVATE = "private/";

        //-- Example related --
        public static final String COMPANY = "api/company/";
        public static final String OWNER = "api/owner/";
        //---------------------

    }

    public class Api {

        public class Types {

            public class Data {
                public static final String STRING = "string";
            }

            public class Param {
                public static final String HEADER = "header";
            }

        }

        public class Operations {

            public class Values {
                public static final String CREATE = "Creates a new resource";
                public static final String READ = "Read by ID";
                public static final String UPDATE = "Update by ID";
                public static final String DELETE = "Delete by ID";
                public static final String LIST = "Lists";
                public static final String PATCH = "Partially updates by ID";
            }

        }

        public class Responses {

            public class Containers {
                public static final String LIST = "List";
            }

            public class Codes {
                public static final int OK = 200;
                public static final int CREATED = 201;
                public static final int NO_CONTENT = 204;
                public static final int BAD_REQUEST = 400;
                public static final int UNAUTHORIZED = 401;
                public static final int FORBIDDEN = 403;
                public static final int NOT_FOUND = 404;
                public static final int CONFLICT = 409;
                public static final int PRECONDITION_FAILED = 412;
                public static final int INTERNAL_SERVER_ERROR = 500;
            }

            public class Messages {
                public static final String OK = "OK: The request has succeeded.";
                public static final String CREATED = "CREATED: The request has been fulfilled and resulted in a new resource being created.";
                public static final String NO_CONTENT = "NO CONTENT: The server has fulfilled the request but does not need to return an entity-body, and might want to return updated metainformation.";
                public static final String BAD_REQUEST = "BAD REQUEST: The request could not be understood by the server due to malformed syntax.";
                public static final String UNAUTHORIZED = "UNAUTHORIZED: The request requires user authentication.";
                public static final String FORBIDDEN = "FORBIDDEN: The server understood the request, but is refusing to fulfill it.";
                public static final String NOT_FOUND = "NOT FOUND: The server has not found anything matching the Request-URI.";
                public static final String CONFLICT = "CONFLICT: The request could not be completed due to a conflict with the current state of the resource.";
                public static final String PRECONDITION_FAILED = "PRE_CONDITION_FAILED: The precondition given in one or more of the request-header fields evaluated to false when it was tested on the server.";
                public static final String INTERNAL_SERVER_ERROR = "INTERNAL SERVER ERROR: The server encountered an unexpected condition which prevented it from fulfilling the request.";
            }
        }

        public class Params {

            public class Names {
                public static final String AUTHORIZATION = "Authorization";
            }

            public class Values {
                public static final String AUTHORIZATION = "Bearer {access_token}";
            }
        }
    }

}

