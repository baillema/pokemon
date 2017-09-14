import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;

public class ElasticSearch {
    //Max number of element displayed
    int size = 10;

    TransportClient client;

    /**
     * Constructor for the Search class
     */
    public ElasticSearch()
    {
        Settings settings = Settings.builder()
                                    .put("cluster.name", "pokelastic")
                                    .build();
        client = new PreBuiltXPackTransportClient(settings);
        try {
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
        } catch (UnknownHostException e) {e.printStackTrace();}
    }

    /**
     * Function to get all elements in the pokemons index
     * @return response of the search request in json
     */
    public String matchAll()
    {
        SearchResponse response = client.prepareSearch("pokemons")
                                        .setQuery(QueryBuilders.matchAllQuery())
                                        .setSize(size)
                                        .get();
        return response.toString();
    }
}
