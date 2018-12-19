/**
 * Copyright 2018-2019 SmartCommunity Lab(FBK-ICT).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

/*
 * Gamification Engine API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package it.smartcommunitylab.oauth.api;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import it.smartcommunitylab.ApiCallback;
import it.smartcommunitylab.ApiClient;
import it.smartcommunitylab.ApiException;
import it.smartcommunitylab.ApiResponse;
import it.smartcommunitylab.Configuration;
import it.smartcommunitylab.Pair;
import it.smartcommunitylab.ProgressRequestBody;
import it.smartcommunitylab.ProgressResponseBody;
import it.smartcommunitylab.model.Notification;

public class DomainNotificationControllerApi {
    private ApiClient apiClient;

    public DomainNotificationControllerApi() {
        this(Configuration.getDefaultApiClient());
    }

    public DomainNotificationControllerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for readNotificationUsingGET2
     * @param domain domain (required)
     * @param gameId gameId (required)
     * @param fromTs fromTs (optional, default to -1)
     * @param toTs toTs (optional, default to -1)
     * @param includeTypes includeTypes (optional)
     * @param excludeTypes excludeTypes (optional)
     * @param page Results page you want to retrieve  (optional)
     * @param size Number of records per page. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call readNotificationUsingGET2Call(String domain, String gameId, Long fromTs, Long toTs, List<String> includeTypes, List<String> excludeTypes, String page, String size, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/{domain}/notification/game/{gameId}"
            .replaceAll("\\{" + "domain" + "\\}", apiClient.escapeString(domain.toString()))
            .replaceAll("\\{" + "gameId" + "\\}", apiClient.escapeString(gameId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (fromTs != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("fromTs", fromTs));
        if (toTs != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("toTs", toTs));
        if (includeTypes != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "includeTypes", includeTypes));
        if (excludeTypes != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "excludeTypes", excludeTypes));
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
        if (size != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("size", size));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call readNotificationUsingGET2ValidateBeforeCall(String domain, String gameId, Long fromTs, Long toTs, List<String> includeTypes, List<String> excludeTypes, String page, String size, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'domain' is set
        if (domain == null) {
            throw new ApiException("Missing the required parameter 'domain' when calling readNotificationUsingGET2(Async)");
        }
        
        // verify the required parameter 'gameId' is set
        if (gameId == null) {
            throw new ApiException("Missing the required parameter 'gameId' when calling readNotificationUsingGET2(Async)");
        }
        

        com.squareup.okhttp.Call call = readNotificationUsingGET2Call(domain, gameId, fromTs, toTs, includeTypes, excludeTypes, page, size, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get game notifications
     * 
     * @param domain domain (required)
     * @param gameId gameId (required)
     * @param fromTs fromTs (optional, default to -1)
     * @param toTs toTs (optional, default to -1)
     * @param includeTypes includeTypes (optional)
     * @param excludeTypes excludeTypes (optional)
     * @param page Results page you want to retrieve  (optional)
     * @param size Number of records per page. (optional)
     * @return List&lt;Notification&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Notification> readNotificationUsingGET2(String domain, String gameId, Long fromTs, Long toTs, List<String> includeTypes, List<String> excludeTypes, String page, String size) throws ApiException {
        ApiResponse<List<Notification>> resp = readNotificationUsingGET2WithHttpInfo(domain, gameId, fromTs, toTs, includeTypes, excludeTypes, page, size);
        return resp.getData();
    }

    /**
     * Get game notifications
     * 
     * @param domain domain (required)
     * @param gameId gameId (required)
     * @param fromTs fromTs (optional, default to -1)
     * @param toTs toTs (optional, default to -1)
     * @param includeTypes includeTypes (optional)
     * @param excludeTypes excludeTypes (optional)
     * @param page Results page you want to retrieve  (optional)
     * @param size Number of records per page. (optional)
     * @return ApiResponse&lt;List&lt;Notification&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Notification>> readNotificationUsingGET2WithHttpInfo(String domain, String gameId, Long fromTs, Long toTs, List<String> includeTypes, List<String> excludeTypes, String page, String size) throws ApiException {
        com.squareup.okhttp.Call call = readNotificationUsingGET2ValidateBeforeCall(domain, gameId, fromTs, toTs, includeTypes, excludeTypes, page, size, null, null);
        Type localVarReturnType = new TypeToken<List<Notification>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get game notifications (asynchronously)
     * 
     * @param domain domain (required)
     * @param gameId gameId (required)
     * @param fromTs fromTs (optional, default to -1)
     * @param toTs toTs (optional, default to -1)
     * @param includeTypes includeTypes (optional)
     * @param excludeTypes excludeTypes (optional)
     * @param page Results page you want to retrieve  (optional)
     * @param size Number of records per page. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call readNotificationUsingGET2Async(String domain, String gameId, Long fromTs, Long toTs, List<String> includeTypes, List<String> excludeTypes, String page, String size, final ApiCallback<List<Notification>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = readNotificationUsingGET2ValidateBeforeCall(domain, gameId, fromTs, toTs, includeTypes, excludeTypes, page, size, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Notification>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for readPlayerNotificationUsingGET
     * @param domain domain (required)
     * @param gameId gameId (required)
     * @param playerId playerId (required)
     * @param fromTs fromTs (optional, default to -1)
     * @param toTs toTs (optional, default to -1)
     * @param includeTypes includeTypes (optional)
     * @param excludeTypes excludeTypes (optional)
     * @param page Results page you want to retrieve  (optional)
     * @param size Number of records per page. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call readPlayerNotificationUsingGETCall(String domain, String gameId, String playerId, Long fromTs, Long toTs, List<String> includeTypes, List<String> excludeTypes, String page, String size, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/{domain}/notification/game/{gameId}/player/{playerId}"
            .replaceAll("\\{" + "domain" + "\\}", apiClient.escapeString(domain.toString()))
            .replaceAll("\\{" + "gameId" + "\\}", apiClient.escapeString(gameId.toString()))
            .replaceAll("\\{" + "playerId" + "\\}", apiClient.escapeString(playerId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (fromTs != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("fromTs", fromTs));
        if (toTs != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("toTs", toTs));
        if (includeTypes != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "includeTypes", includeTypes));
        if (excludeTypes != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "excludeTypes", excludeTypes));
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
        if (size != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("size", size));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call readPlayerNotificationUsingGETValidateBeforeCall(String domain, String gameId, String playerId, Long fromTs, Long toTs, List<String> includeTypes, List<String> excludeTypes, String page, String size, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'domain' is set
        if (domain == null) {
            throw new ApiException("Missing the required parameter 'domain' when calling readPlayerNotificationUsingGET(Async)");
        }
        
        // verify the required parameter 'gameId' is set
        if (gameId == null) {
            throw new ApiException("Missing the required parameter 'gameId' when calling readPlayerNotificationUsingGET(Async)");
        }
        
        // verify the required parameter 'playerId' is set
        if (playerId == null) {
            throw new ApiException("Missing the required parameter 'playerId' when calling readPlayerNotificationUsingGET(Async)");
        }
        

        com.squareup.okhttp.Call call = readPlayerNotificationUsingGETCall(domain, gameId, playerId, fromTs, toTs, includeTypes, excludeTypes, page, size, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get player notifications
     * 
     * @param domain domain (required)
     * @param gameId gameId (required)
     * @param playerId playerId (required)
     * @param fromTs fromTs (optional, default to -1)
     * @param toTs toTs (optional, default to -1)
     * @param includeTypes includeTypes (optional)
     * @param excludeTypes excludeTypes (optional)
     * @param page Results page you want to retrieve  (optional)
     * @param size Number of records per page. (optional)
     * @return List&lt;Notification&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Notification> readPlayerNotificationUsingGET(String domain, String gameId, String playerId, Long fromTs, Long toTs, List<String> includeTypes, List<String> excludeTypes, String page, String size) throws ApiException {
        ApiResponse<List<Notification>> resp = readPlayerNotificationUsingGETWithHttpInfo(domain, gameId, playerId, fromTs, toTs, includeTypes, excludeTypes, page, size);
        return resp.getData();
    }

    /**
     * Get player notifications
     * 
     * @param domain domain (required)
     * @param gameId gameId (required)
     * @param playerId playerId (required)
     * @param fromTs fromTs (optional, default to -1)
     * @param toTs toTs (optional, default to -1)
     * @param includeTypes includeTypes (optional)
     * @param excludeTypes excludeTypes (optional)
     * @param page Results page you want to retrieve  (optional)
     * @param size Number of records per page. (optional)
     * @return ApiResponse&lt;List&lt;Notification&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Notification>> readPlayerNotificationUsingGETWithHttpInfo(String domain, String gameId, String playerId, Long fromTs, Long toTs, List<String> includeTypes, List<String> excludeTypes, String page, String size) throws ApiException {
        com.squareup.okhttp.Call call = readPlayerNotificationUsingGETValidateBeforeCall(domain, gameId, playerId, fromTs, toTs, includeTypes, excludeTypes, page, size, null, null);
        Type localVarReturnType = new TypeToken<List<Notification>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get player notifications (asynchronously)
     * 
     * @param domain domain (required)
     * @param gameId gameId (required)
     * @param playerId playerId (required)
     * @param fromTs fromTs (optional, default to -1)
     * @param toTs toTs (optional, default to -1)
     * @param includeTypes includeTypes (optional)
     * @param excludeTypes excludeTypes (optional)
     * @param page Results page you want to retrieve  (optional)
     * @param size Number of records per page. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call readPlayerNotificationUsingGETAsync(String domain, String gameId, String playerId, Long fromTs, Long toTs, List<String> includeTypes, List<String> excludeTypes, String page, String size, final ApiCallback<List<Notification>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = readPlayerNotificationUsingGETValidateBeforeCall(domain, gameId, playerId, fromTs, toTs, includeTypes, excludeTypes, page, size, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Notification>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for readTeamNotificationUsingGET
     * @param domain domain (required)
     * @param gameId gameId (required)
     * @param teamId teamId (required)
     * @param fromTs fromTs (optional, default to -1)
     * @param toTs toTs (optional, default to -1)
     * @param includeTypes includeTypes (optional)
     * @param excludeTypes excludeTypes (optional)
     * @param page Results page you want to retrieve  (optional)
     * @param size Number of records per page. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call readTeamNotificationUsingGETCall(String domain, String gameId, String teamId, Long fromTs, Long toTs, List<String> includeTypes, List<String> excludeTypes, String page, String size, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/{domain}/notification/game/{gameId}/team/{teamId}"
            .replaceAll("\\{" + "domain" + "\\}", apiClient.escapeString(domain.toString()))
            .replaceAll("\\{" + "gameId" + "\\}", apiClient.escapeString(gameId.toString()))
            .replaceAll("\\{" + "teamId" + "\\}", apiClient.escapeString(teamId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (fromTs != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("fromTs", fromTs));
        if (toTs != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("toTs", toTs));
        if (includeTypes != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "includeTypes", includeTypes));
        if (excludeTypes != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("multi", "excludeTypes", excludeTypes));
        if (page != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("page", page));
        if (size != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("size", size));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call readTeamNotificationUsingGETValidateBeforeCall(String domain, String gameId, String teamId, Long fromTs, Long toTs, List<String> includeTypes, List<String> excludeTypes, String page, String size, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'domain' is set
        if (domain == null) {
            throw new ApiException("Missing the required parameter 'domain' when calling readTeamNotificationUsingGET(Async)");
        }
        
        // verify the required parameter 'gameId' is set
        if (gameId == null) {
            throw new ApiException("Missing the required parameter 'gameId' when calling readTeamNotificationUsingGET(Async)");
        }
        
        // verify the required parameter 'teamId' is set
        if (teamId == null) {
            throw new ApiException("Missing the required parameter 'teamId' when calling readTeamNotificationUsingGET(Async)");
        }
        

        com.squareup.okhttp.Call call = readTeamNotificationUsingGETCall(domain, gameId, teamId, fromTs, toTs, includeTypes, excludeTypes, page, size, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get team notifications
     * 
     * @param domain domain (required)
     * @param gameId gameId (required)
     * @param teamId teamId (required)
     * @param fromTs fromTs (optional, default to -1)
     * @param toTs toTs (optional, default to -1)
     * @param includeTypes includeTypes (optional)
     * @param excludeTypes excludeTypes (optional)
     * @param page Results page you want to retrieve  (optional)
     * @param size Number of records per page. (optional)
     * @return List&lt;Notification&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Notification> readTeamNotificationUsingGET(String domain, String gameId, String teamId, Long fromTs, Long toTs, List<String> includeTypes, List<String> excludeTypes, String page, String size) throws ApiException {
        ApiResponse<List<Notification>> resp = readTeamNotificationUsingGETWithHttpInfo(domain, gameId, teamId, fromTs, toTs, includeTypes, excludeTypes, page, size);
        return resp.getData();
    }

    /**
     * Get team notifications
     * 
     * @param domain domain (required)
     * @param gameId gameId (required)
     * @param teamId teamId (required)
     * @param fromTs fromTs (optional, default to -1)
     * @param toTs toTs (optional, default to -1)
     * @param includeTypes includeTypes (optional)
     * @param excludeTypes excludeTypes (optional)
     * @param page Results page you want to retrieve  (optional)
     * @param size Number of records per page. (optional)
     * @return ApiResponse&lt;List&lt;Notification&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Notification>> readTeamNotificationUsingGETWithHttpInfo(String domain, String gameId, String teamId, Long fromTs, Long toTs, List<String> includeTypes, List<String> excludeTypes, String page, String size) throws ApiException {
        com.squareup.okhttp.Call call = readTeamNotificationUsingGETValidateBeforeCall(domain, gameId, teamId, fromTs, toTs, includeTypes, excludeTypes, page, size, null, null);
        Type localVarReturnType = new TypeToken<List<Notification>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get team notifications (asynchronously)
     * 
     * @param domain domain (required)
     * @param gameId gameId (required)
     * @param teamId teamId (required)
     * @param fromTs fromTs (optional, default to -1)
     * @param toTs toTs (optional, default to -1)
     * @param includeTypes includeTypes (optional)
     * @param excludeTypes excludeTypes (optional)
     * @param page Results page you want to retrieve  (optional)
     * @param size Number of records per page. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call readTeamNotificationUsingGETAsync(String domain, String gameId, String teamId, Long fromTs, Long toTs, List<String> includeTypes, List<String> excludeTypes, String page, String size, final ApiCallback<List<Notification>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = readTeamNotificationUsingGETValidateBeforeCall(domain, gameId, teamId, fromTs, toTs, includeTypes, excludeTypes, page, size, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Notification>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
