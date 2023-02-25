# Flickr-Project-map06-johnabbott
Flickr-Project-map06-johnabbott

Retrofit for making API calls and parsing JSON data.

Create a Java class to represent the data model for the Flickr photo object, with attributes that match the JSON data returned by the API.

Create a Retrofit interface that defines the API endpoints for the Flickr API, Define methods that correspond to the API calls such as retrieving a list of photos.

Use Gson to parse the JSON response from the API into instances of your Photo class. use Retrofit's converter factory to automatically convert the response into a list of Photo objects.

Create a RecyclerView to display the list of photos. You can create a custom RecyclerView adapter and view holder to display each photo in a card view.

Load the photos asynchronously using a background thread or a library Glide.

Handle user interaction with the RecyclerView, clicking on a photo to view it in a detail view.

Add search & filtering.
