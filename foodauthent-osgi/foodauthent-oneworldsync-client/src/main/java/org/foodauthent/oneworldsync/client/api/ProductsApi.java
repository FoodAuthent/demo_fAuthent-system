package org.foodauthent.oneworldsync.client.api;

import org.foodauthent.oneworldsync.client.ApiException;
import org.foodauthent.oneworldsync.client.ApiClient;
import org.foodauthent.oneworldsync.client.ApiResponse;
import org.foodauthent.oneworldsync.client.Configuration;
import org.foodauthent.oneworldsync.client.Pair;

import javax.ws.rs.core.GenericType;

import org.foodauthent.oneworldsync.client.model.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-07-25T20:10:55.785Z")
public class ProductsApi {
	private ApiClient apiClient;

	public ProductsApi() {
		this(Configuration.getDefaultApiClient());
	}

	public ProductsApi(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	public ApiClient getApiClient() {
		return apiClient;
	}

	public void setApiClient(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	/**
	 * &lt;p&gt;&lt;strong&gt;Product Search&lt;/strong&gt;&lt;/p&gt; &lt;p&gt; The
	 * search will get a pre-defined subset (~20 attributes) of information on
	 * products in the Content1 Repository. The Product Search request provides
	 * enough information to choose which product you would like to retrieve a full
	 * set of attributes to be used within your application or website.&lt;/p&gt;
	 * Content1 Search API will allow you to search using free text, category code,
	 * or advanced search options. The advanced search and filters can be used to
	 * narrow the numbers of products which are returned. The full list of available
	 * parameters which can be used to search or filter can be found by clicking on
	 * the corresponding hyperlink in the query paramter below.
	 * 
	 * @param appId
	 *            A unique ID, generated by 1WorldSync to access the Web Services.
	 *            This was sent to you upon registering and being approved at &lt;a
	 *            href&#x3D;\&quot;#\&quot;
	 *            onclick&#x3D;\&quot;openWindow(&#39;https://developer.1worldsync.com&#39;,
	 *            &#39;Content1&#39;)\&quot;&gt;developer.1worldsync.com&lt;/a&gt;
	 *            (required)
	 * @param searchType
	 *            The type of search to be performed. If you chose
	 *            &lt;br/&gt;&lt;br/&gt;&lt;ul&gt;&lt;li&gt;freeTextSearch - pass
	 *            any search string in the query
	 *            parameter&lt;/li&gt;&lt;li&gt;categoryCode - pass the Category
	 *            value in the query parameter&lt;/li&gt;&lt;li&gt;advancedSearch -
	 *            pass the search attribute name and value in the query
	 *            parameter&lt;/li&gt;&lt;/ul&gt; (required)
	 * @param query
	 *            &lt;p&gt;This parameter specifies the criteria for which you want
	 *            to perform the search.&lt;/p&gt;&lt;p&gt; When using the freeText
	 *            search you would specify a word, phrase, or ID to search on. If a
	 *            categoryCode search is selected the category code should be
	 *            provided. When advancedSearch is selected you can create a dynamic
	 *            query using logical operators (and/or/not) along with a
	 *            corresponding attribute to create a complex query.&lt;/p&gt;
	 *            &lt;p&gt;You can click on the view attributes link to obtain a
	 *            list of valid searchable attributes. &lt;a
	 *            href&#x3D;\&quot;#\&quot;
	 *            onclick&#x3D;\&quot;openWindow(&#39;SearchAttributes.htm&#39;,
	 *            &#39;Attributes&#39;)\&quot;&gt;View
	 *            Attributes&lt;/a&gt;&lt;/p&gt;&lt;p&gt;Examples:&lt;/p&gt;&lt;p&gt;&lt;ul&gt;&lt;li&gt;freeTextSearch
	 *            - query&#x3D;\&quot;Tuscan
	 *            milk\&quot;&lt;/li&gt;&lt;li&gt;categoryCode -
	 *            query&#x3D;\&quot;Fruits -
	 *            Unprepared/Unprocessed(Frozen)\&quot;&lt;/li&gt;&lt;li&gt;advancedSearch
	 *            - query&#x3D;productName:\&quot;Healthy and
	 *            tastySoybeanmilk\&quot;&lt;/li&gt;&lt;/ul&gt;&lt;/p&gt;&lt;p&gt;Note:
	 *            For partial text search on a single word, append
	 *            &#39;&amp;#65290;&#39; in the query parameter. You can not use a
	 *            partial text search for a
	 *            phrase.&lt;/p&gt;&lt;p&gt;Examples:&lt;/p&gt;&lt;p&gt;To search
	 *            for Beverages in a
	 *            freeTextSearch&lt;ul&gt;&lt;li&gt;query&#x3D;\&quot;Bever&amp;#65290;\&quot;&lt;/li&gt;&lt;li&gt;query&#x3D;\&quot;&amp;#65290;verag&amp;#65290;\&quot;&lt;/li&gt;&lt;li&gt;query&#x3D;\&quot;&amp;#65290;erages\&quot;&lt;/li&gt;&lt;li&gt;query&#x3D;\&quot;Tuscan
	 *            mi&amp;#65290;\&quot; - is not
	 *            valid&lt;/li&gt;&lt;/ul&gt;&lt;/p&gt; (required)
	 * @param accessMdm
	 *            Specify the device used for accessing the API (required)
	 * @param TIMESTAMP
	 *            &lt;button type&#x3D;\&quot;button\&quot;
	 *            onclick&#x3D;\&quot;generateTimeStamp(); return
	 *            false;\&quot;&gt;Generate
	 *            TIMESTAMP&lt;/button&gt;&lt;p&gt;Security Checks for web service
	 *            will retrieve the value and will compare with the (current time –
	 *            5 minutes). If the supplied time stamp is within the criteria,
	 *            then it will allow the user to access the WS. TIMESTAMP should be
	 *            provided as Coordinated Universal Time format, such as
	 *            \&quot;2015-03-03T18:12:22Z\&quot; or and offset to UTC such as
	 *            \&quot;2015-03-03T23:12:22+05:00\&quot; or
	 *            \&quot;2015-03-03T13:12:22-05:00\&quot;&lt;/p&gt; (required)
	 * @param rows
	 *            Number of results to return. If value is not set the default is
	 *            set to the maximum value which is 500 rows. (optional)
	 * @param start
	 *            Start index of returned result set. If the value is not provided,
	 *            then by default, it is set to the minimum value of
	 *            1.&lt;br/&gt;This should be used in conjunction with the rows
	 *            parameter to return specific result sets that require
	 *            pagination.&lt;br/&gt;For example If you want to view results
	 *            between 50 to 100, the start index would be 50 and rows would be
	 *            50. &lt;br/&gt;Or, if you wish to view the first 100 products of
	 *            your search result, the start index would be 1 and rows would be
	 *            100. (optional)
	 * @param filter
	 *            This parameter helps to filter the search result based on the
	 *            specified attributes. (optional)
	 * @param sortOrder
	 *            This parameter is used for defining the sort order. If asc is sent
	 *            then search results will be sorted in ascending order and if
	 *            sortOrder is desc then result will be sorted in descending order.
	 *            (optional)
	 * @param sortColumn
	 *            This parameter specifies which attribute to sort on using the
	 *            sortOrder specified. Not all attributes can be sorted on. Here is
	 *            a list of sortable attributes. &lt;a href&#x3D;\&quot;#\&quot;
	 *            onclick&#x3D;\&quot;openWindow(&#39;SortAttributes.htm&#39;,
	 *            &#39;SortAttributes&#39;)\&quot;&gt;View Attributes&lt;/a&gt;
	 *            (optional)
	 * @param matchScore
	 *            Set a value to this parameter to perform a ‘closest-match’ search.
	 *            A lower value would ensure loose searching and return closer
	 *            results whereas a higher value would ensure tight searching and
	 *            return less or no results.&lt;br/&gt;Default value is 1.0.
	 *            (optional)
	 * @param cursorMark
	 *            The cursor mark must be provided to continue a search from the
	 *            point where the previous call left off. The nextCursorMark value
	 *            that is returned in the JSON should be used to feed into this
	 *            parameter. (optional)
	 * @param geoLocAccessLatd
	 *            Provide the latitude of the geographical location from where the
	 *            request is originating. Note that this is not the location of your
	 *            hardware, but is the location of where the initiating requestor is
	 *            located. (optional)
	 * @param geoLocAccessLong
	 *            Provide the longitude of the geographical location from where the
	 *            request is originating. Note that this is not the location of your
	 *            hardware, but is the location of where the initiating requestor is
	 *            located. (optional)
	 * @return Response
	 * @throws ApiException
	 *             if fails to make API call
	 */
	public Response productsGet(String appId, String searchType, String query, String accessMdm,
			String TIMESTAMP, Integer rows, Integer start, String filter, String sortOrder, String sortColumn,
			String matchScore, String cursorMark, Double geoLocAccessLatd, Double geoLocAccessLong)
			throws ApiException {
		return productsGetWithHttpInfo(appId, searchType, query, accessMdm, TIMESTAMP, rows, start, filter, sortOrder,
				sortColumn, matchScore, cursorMark, geoLocAccessLatd, geoLocAccessLong).getData();
	}

	/**
	 * &lt;p&gt;&lt;strong&gt;Product Search&lt;/strong&gt;&lt;/p&gt; &lt;p&gt; The
	 * search will get a pre-defined subset (~20 attributes) of information on
	 * products in the Content1 Repository. The Product Search request provides
	 * enough information to choose which product you would like to retrieve a full
	 * set of attributes to be used within your application or website.&lt;/p&gt;
	 * Content1 Search API will allow you to search using free text, category code,
	 * or advanced search options. The advanced search and filters can be used to
	 * narrow the numbers of products which are returned. The full list of available
	 * parameters which can be used to search or filter can be found by clicking on
	 * the corresponding hyperlink in the query paramter below.
	 * 
	 * @param appId
	 *            A unique ID, generated by 1WorldSync to access the Web Services.
	 *            This was sent to you upon registering and being approved at &lt;a
	 *            href&#x3D;\&quot;#\&quot;
	 *            onclick&#x3D;\&quot;openWindow(&#39;https://developer.1worldsync.com&#39;,
	 *            &#39;Content1&#39;)\&quot;&gt;developer.1worldsync.com&lt;/a&gt;
	 *            (required)
	 * @param searchType
	 *            The type of search to be performed. If you chose
	 *            &lt;br/&gt;&lt;br/&gt;&lt;ul&gt;&lt;li&gt;freeTextSearch - pass
	 *            any search string in the query
	 *            parameter&lt;/li&gt;&lt;li&gt;categoryCode - pass the Category
	 *            value in the query parameter&lt;/li&gt;&lt;li&gt;advancedSearch -
	 *            pass the search attribute name and value in the query
	 *            parameter&lt;/li&gt;&lt;/ul&gt; (required)
	 * @param query
	 *            &lt;p&gt;This parameter specifies the criteria for which you want
	 *            to perform the search.&lt;/p&gt;&lt;p&gt; When using the freeText
	 *            search you would specify a word, phrase, or ID to search on. If a
	 *            categoryCode search is selected the category code should be
	 *            provided. When advancedSearch is selected you can create a dynamic
	 *            query using logical operators (and/or/not) along with a
	 *            corresponding attribute to create a complex query.&lt;/p&gt;
	 *            &lt;p&gt;You can click on the view attributes link to obtain a
	 *            list of valid searchable attributes. &lt;a
	 *            href&#x3D;\&quot;#\&quot;
	 *            onclick&#x3D;\&quot;openWindow(&#39;SearchAttributes.htm&#39;,
	 *            &#39;Attributes&#39;)\&quot;&gt;View
	 *            Attributes&lt;/a&gt;&lt;/p&gt;&lt;p&gt;Examples:&lt;/p&gt;&lt;p&gt;&lt;ul&gt;&lt;li&gt;freeTextSearch
	 *            - query&#x3D;\&quot;Tuscan
	 *            milk\&quot;&lt;/li&gt;&lt;li&gt;categoryCode -
	 *            query&#x3D;\&quot;Fruits -
	 *            Unprepared/Unprocessed(Frozen)\&quot;&lt;/li&gt;&lt;li&gt;advancedSearch
	 *            - query&#x3D;productName:\&quot;Healthy and
	 *            tastySoybeanmilk\&quot;&lt;/li&gt;&lt;/ul&gt;&lt;/p&gt;&lt;p&gt;Note:
	 *            For partial text search on a single word, append
	 *            &#39;&amp;#65290;&#39; in the query parameter. You can not use a
	 *            partial text search for a
	 *            phrase.&lt;/p&gt;&lt;p&gt;Examples:&lt;/p&gt;&lt;p&gt;To search
	 *            for Beverages in a
	 *            freeTextSearch&lt;ul&gt;&lt;li&gt;query&#x3D;\&quot;Bever&amp;#65290;\&quot;&lt;/li&gt;&lt;li&gt;query&#x3D;\&quot;&amp;#65290;verag&amp;#65290;\&quot;&lt;/li&gt;&lt;li&gt;query&#x3D;\&quot;&amp;#65290;erages\&quot;&lt;/li&gt;&lt;li&gt;query&#x3D;\&quot;Tuscan
	 *            mi&amp;#65290;\&quot; - is not
	 *            valid&lt;/li&gt;&lt;/ul&gt;&lt;/p&gt; (required)
	 * @param accessMdm
	 *            Specify the device used for accessing the API (required)
	 * @param TIMESTAMP
	 *            &lt;button type&#x3D;\&quot;button\&quot;
	 *            onclick&#x3D;\&quot;generateTimeStamp(); return
	 *            false;\&quot;&gt;Generate
	 *            TIMESTAMP&lt;/button&gt;&lt;p&gt;Security Checks for web service
	 *            will retrieve the value and will compare with the (current time –
	 *            5 minutes). If the supplied time stamp is within the criteria,
	 *            then it will allow the user to access the WS. TIMESTAMP should be
	 *            provided as Coordinated Universal Time format, such as
	 *            \&quot;2015-03-03T18:12:22Z\&quot; or and offset to UTC such as
	 *            \&quot;2015-03-03T23:12:22+05:00\&quot; or
	 *            \&quot;2015-03-03T13:12:22-05:00\&quot;&lt;/p&gt; (required)
	 * @param rows
	 *            Number of results to return. If value is not set the default is
	 *            set to the maximum value which is 500 rows. (optional)
	 * @param start
	 *            Start index of returned result set. If the value is not provided,
	 *            then by default, it is set to the minimum value of
	 *            1.&lt;br/&gt;This should be used in conjunction with the rows
	 *            parameter to return specific result sets that require
	 *            pagination.&lt;br/&gt;For example If you want to view results
	 *            between 50 to 100, the start index would be 50 and rows would be
	 *            50. &lt;br/&gt;Or, if you wish to view the first 100 products of
	 *            your search result, the start index would be 1 and rows would be
	 *            100. (optional)
	 * @param filter
	 *            This parameter helps to filter the search result based on the
	 *            specified attributes. (optional)
	 * @param sortOrder
	 *            This parameter is used for defining the sort order. If asc is sent
	 *            then search results will be sorted in ascending order and if
	 *            sortOrder is desc then result will be sorted in descending order.
	 *            (optional)
	 * @param sortColumn
	 *            This parameter specifies which attribute to sort on using the
	 *            sortOrder specified. Not all attributes can be sorted on. Here is
	 *            a list of sortable attributes. &lt;a href&#x3D;\&quot;#\&quot;
	 *            onclick&#x3D;\&quot;openWindow(&#39;SortAttributes.htm&#39;,
	 *            &#39;SortAttributes&#39;)\&quot;&gt;View Attributes&lt;/a&gt;
	 *            (optional)
	 * @param matchScore
	 *            Set a value to this parameter to perform a ‘closest-match’ search.
	 *            A lower value would ensure loose searching and return closer
	 *            results whereas a higher value would ensure tight searching and
	 *            return less or no results.&lt;br/&gt;Default value is 1.0.
	 *            (optional)
	 * @param cursorMark
	 *            The cursor mark must be provided to continue a search from the
	 *            point where the previous call left off. The nextCursorMark value
	 *            that is returned in the JSON should be used to feed into this
	 *            parameter. (optional)
	 * @param geoLocAccessLatd
	 *            Provide the latitude of the geographical location from where the
	 *            request is originating. Note that this is not the location of your
	 *            hardware, but is the location of where the initiating requestor is
	 *            located. (optional)
	 * @param geoLocAccessLong
	 *            Provide the longitude of the geographical location from where the
	 *            request is originating. Note that this is not the location of your
	 *            hardware, but is the location of where the initiating requestor is
	 *            located. (optional)
	 * @return ApiResponse&lt;Response&gt;
	 * @throws ApiException
	 *             if fails to make API call
	 */
	public ApiResponse<Response> productsGetWithHttpInfo(String appId, String searchType, String query,
			String accessMdm, String TIMESTAMP, Integer rows, Integer start, String filter, String sortOrder,
			String sortColumn, String matchScore, String cursorMark, Double geoLocAccessLatd, Double geoLocAccessLong)
			throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'appId' is set
		if (appId == null) {
			throw new ApiException(400, "Missing the required parameter 'appId' when calling productsGet");
		}

		// verify the required parameter 'searchType' is set
		if (searchType == null) {
			throw new ApiException(400, "Missing the required parameter 'searchType' when calling productsGet");
		}

		// verify the required parameter 'query' is set
		if (query == null) {
			throw new ApiException(400, "Missing the required parameter 'query' when calling productsGet");
		}

		// verify the required parameter 'accessMdm' is set
		if (accessMdm == null) {
			throw new ApiException(400, "Missing the required parameter 'accessMdm' when calling productsGet");
		}

		// verify the required parameter 'TIMESTAMP' is set
		if (TIMESTAMP == null) {
			throw new ApiException(400, "Missing the required parameter 'TIMESTAMP' when calling productsGet");
		}

		// create path and map variables
		String localVarPath = "/products";

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(apiClient.parameterToPairs("", "app_id", appId));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "searchType", searchType));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "query", query));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "access_mdm", accessMdm));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "TIMESTAMP", TIMESTAMP));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "rows", rows));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "start", start));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "filter", filter));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "sortOrder", sortOrder));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "sortColumn", sortColumn));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "matchScore", matchScore));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "cursorMark", cursorMark));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "geo_loc_access_latd", geoLocAccessLatd));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "geo_loc_access_long", geoLocAccessLong));

		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

		String[] localVarAuthNames = new String[] {};

		GenericType<Response> localVarReturnType = new GenericType<Response>() {
		};
		return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
				localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}

	/**
	 * &lt;p&gt;&lt;strong&gt;Product Fetch&lt;/strong&gt;&lt;/p&gt;&lt;p&gt; The
	 * fetch API returns the full set of attributes contianed in the Content1
	 * Repository.&lt;/p&gt; &lt;p&gt;The fetch API is used to return the full set
	 * of attributes for the product.Use the ItemReferenceId returned from the
	 * search to fetch that product. You can pass a playlist in the attrset field to
	 * limit the number of attributes returned that are relavent to your systems
	 * needs, reducing processing time and bandwidth.&lt;/p&gt;
	 * 
	 * @param appId
	 *            A unique ID, generated by 1WorldSync to access the Web Services.
	 *            This was sent to you upon registering and being approved at &lt;a
	 *            href&#x3D;\&quot;#\&quot;
	 *            onclick&#x3D;\&quot;openWindow(&#39;https://developer.1worldsync.com&#39;,
	 *            &#39;ContentNOW&#39;)\&quot;&gt;developer.1worldsync.com.&lt;/a&gt;
	 *            (required)
	 * @param itemReferenceId
	 *            The identifier of the item to fetch as returned in the search API.
	 *            (required)
	 * @param accessMdm
	 *            Specify the device used for accessing the API (required)
	 * @param TIMESTAMP
	 *            &lt;button type&#x3D;\&quot;button\&quot;
	 *            onclick&#x3D;\&quot;generateTimeStamp(); return
	 *            false;\&quot;&gt;Generate
	 *            TIMESTAMP&lt;/button&gt;&lt;p&gt;Security Checks for web service
	 *            will retrieve the value and will compare with the (current time –
	 *            5 minutes). If the supplied time stamp is within the criteria,
	 *            then it will allow the user to access the WS. TIMESTAMP should be
	 *            provided as Coordinated Universal Time format, such as
	 *            \&quot;2015-03-03T18:12:22Z\&quot; or and offset to UTC such as
	 *            \&quot;2015-03-03T23:12:22+05:00\&quot; or
	 *            \&quot;2015-03-03T13:12:22-05:00\&quot;&lt;/p&gt; (required)
	 * @param geoLocAccessLatd
	 *            Latitude component of location. (optional)
	 * @param geoLocAccessLong
	 *            Longitude component of location. (optional)
	 * @param attrset
	 *            &lt;p&gt;A comma seperated list of attribute contexts to be
	 *            returned. &lt;a href&#x3D;\&quot;#\&quot;
	 *            onclick&#x3D;\&quot;openWindow(&#39;AttributeContextLists.htm&#39;,
	 *            &#39;Attribute Context Lists&#39;)\&quot;&gt;View Attribute
	 *            Context
	 *            Lists&lt;/a&gt;&lt;/p&gt;&lt;p&gt;Example:&lt;/p&gt;&lt;p&gt;attrset&#x3D;allergens,ingredients,nutritionals&lt;/p&gt;
	 *            (optional)
	 * @return Response
	 * @throws ApiException
	 *             if fails to make API call
	 */
	public Response productsItemReferenceIdGet(String appId, String itemReferenceId, String accessMdm,
			String TIMESTAMP, Double geoLocAccessLatd, Double geoLocAccessLong, String attrset)
			throws ApiException {
		return productsItemReferenceIdGetWithHttpInfo(appId, itemReferenceId, accessMdm, TIMESTAMP, geoLocAccessLatd,
				geoLocAccessLong, attrset).getData();
	}

	/**
	 * &lt;p&gt;&lt;strong&gt;Product Fetch&lt;/strong&gt;&lt;/p&gt;&lt;p&gt; The
	 * fetch API returns the full set of attributes contianed in the Content1
	 * Repository.&lt;/p&gt; &lt;p&gt;The fetch API is used to return the full set
	 * of attributes for the product.Use the ItemReferenceId returned from the
	 * search to fetch that product. You can pass a playlist in the attrset field to
	 * limit the number of attributes returned that are relavent to your systems
	 * needs, reducing processing time and bandwidth.&lt;/p&gt;
	 * 
	 * @param appId
	 *            A unique ID, generated by 1WorldSync to access the Web Services.
	 *            This was sent to you upon registering and being approved at &lt;a
	 *            href&#x3D;\&quot;#\&quot;
	 *            onclick&#x3D;\&quot;openWindow(&#39;https://developer.1worldsync.com&#39;,
	 *            &#39;ContentNOW&#39;)\&quot;&gt;developer.1worldsync.com.&lt;/a&gt;
	 *            (required)
	 * @param itemReferenceId
	 *            The identifier of the item to fetch as returned in the search API.
	 *            (required)
	 * @param accessMdm
	 *            Specify the device used for accessing the API (required)
	 * @param TIMESTAMP
	 *            &lt;button type&#x3D;\&quot;button\&quot;
	 *            onclick&#x3D;\&quot;generateTimeStamp(); return
	 *            false;\&quot;&gt;Generate
	 *            TIMESTAMP&lt;/button&gt;&lt;p&gt;Security Checks for web service
	 *            will retrieve the value and will compare with the (current time –
	 *            5 minutes). If the supplied time stamp is within the criteria,
	 *            then it will allow the user to access the WS. TIMESTAMP should be
	 *            provided as Coordinated Universal Time format, such as
	 *            \&quot;2015-03-03T18:12:22Z\&quot; or and offset to UTC such as
	 *            \&quot;2015-03-03T23:12:22+05:00\&quot; or
	 *            \&quot;2015-03-03T13:12:22-05:00\&quot;&lt;/p&gt; (required)
	 * @param geoLocAccessLatd
	 *            Latitude component of location. (optional)
	 * @param geoLocAccessLong
	 *            Longitude component of location. (optional)
	 * @param attrset
	 *            &lt;p&gt;A comma seperated list of attribute contexts to be
	 *            returned. &lt;a href&#x3D;\&quot;#\&quot;
	 *            onclick&#x3D;\&quot;openWindow(&#39;AttributeContextLists.htm&#39;,
	 *            &#39;Attribute Context Lists&#39;)\&quot;&gt;View Attribute
	 *            Context
	 *            Lists&lt;/a&gt;&lt;/p&gt;&lt;p&gt;Example:&lt;/p&gt;&lt;p&gt;attrset&#x3D;allergens,ingredients,nutritionals&lt;/p&gt;
	 *            (optional)
	 * @return ApiResponse&lt;Response&gt;
	 * @throws ApiException
	 *             if fails to make API call
	 */
	public ApiResponse<Response> productsItemReferenceIdGetWithHttpInfo(String appId, String itemReferenceId,
			String accessMdm, String TIMESTAMP, Double geoLocAccessLatd, Double geoLocAccessLong,
			String attrset) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'appId' is set
		if (appId == null) {
			throw new ApiException(400,
					"Missing the required parameter 'appId' when calling productsItemReferenceIdGet");
		}

		// verify the required parameter 'itemReferenceId' is set
		if (itemReferenceId == null) {
			throw new ApiException(400,
					"Missing the required parameter 'itemReferenceId' when calling productsItemReferenceIdGet");
		}

		// verify the required parameter 'accessMdm' is set
		if (accessMdm == null) {
			throw new ApiException(400,
					"Missing the required parameter 'accessMdm' when calling productsItemReferenceIdGet");
		}

		// verify the required parameter 'TIMESTAMP' is set
		if (TIMESTAMP == null) {
			throw new ApiException(400,
					"Missing the required parameter 'TIMESTAMP' when calling productsItemReferenceIdGet");
		}

		// create path and map variables
		String localVarPath = "/products/{itemReferenceId}".replaceAll("\\{" + "itemReferenceId" + "\\}",
				apiClient.escapeString(itemReferenceId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(apiClient.parameterToPairs("", "app_id", appId));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "access_mdm", accessMdm));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "TIMESTAMP", TIMESTAMP));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "geo_loc_access_latd", geoLocAccessLatd));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "geo_loc_access_long", geoLocAccessLong));
		localVarQueryParams.addAll(apiClient.parameterToPairs("", "attrset", attrset));

		final String[] localVarAccepts = { "application/json" };
		final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

		String[] localVarAuthNames = new String[] {};

		GenericType<Response> localVarReturnType = new GenericType<Response>() {
		};
		return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams,
				localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
	}
}