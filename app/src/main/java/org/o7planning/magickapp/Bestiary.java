package org.o7planning.magickapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bestiary extends AppCompatActivity {

    List<Beast> beastList = new ArrayList<Beast>();



    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestiary);


        DataBaseHelper db = new DataBaseHelper(Bestiary.this);


        //Beast b0 = new Beast(0,"Dragon","A dragon is a large, serpentine, legendary creature that appears in the folklore of many cultures worldwide. Beliefs about dragons vary considerably through regions, but dragons in western cultures since the High Middle Ages have often been depicted as winged, horned, four-legged, and capable of breathing fire. Dragons in eastern cultures are usually depicted as wingless, four-legged, serpentine creatures with above-average intelligence.The word \"dragon\" has also come to be applied to the Chinese lung, which are associated with good fortune and are thought to have power over rain. Dragons and their associations with rain are the source of the Chinese customs of dragon dancing and dragon boat racing. Many East Asian deities and demigods have dragons as their personal mounts or companions.","https://upload.wikimedia.org/wikipedia/commons/thumb/d/d8/Friedrich-Johann-Justin-Bertuch_Mythical-Creature-Dragon_1806.jpg/796px-Friedrich-Johann-Justin-Bertuch_Mythical-Creature-Dragon_1806.jpg");
        //Beast b1 = new Beast(1,"Chimera","The Chimera (/kɪˈmɪərə/ or /kaɪˈmɪərə/, also Chimaera (Chimæra); Greek: Χίμαιρα, Chímaira \"she-goat\"), according to Greek mythology,[1] was a monstrous fire-breathing hybrid creature of Lycia in Asia Minor, composed of the parts of more than one animal. It is usually depicted as a lion, with the head of a goat protruding from its back, and a tail that might end with a snake's head.[2] It was one of the offspring of Typhon and Echidna and a sibling of such monsters as Cerberus and the Lernaean Hydra.","https://upload.wikimedia.org/wikipedia/commons/thumb/9/96/Ligozzi_%28Una_quimera%29.jpg/1200px-Ligozzi_%28Una_quimera%29.jpg");
//        Beast b2 = new Beast(2,"Ghost","In folklore, a ghost is the soul or spirit of a dead person or animal that can appear to the living. In ghostlore, descriptions of ghosts vary widely from an invisible presence to translucent or barely visible wispy shapes, to realistic, lifelike forms. The deliberate attempt to contact the spirit of a deceased person is known as necromancy, or in spiritism as a séance. Other terms associated with it are apparition, haunt, phantom, poltergeist, shade, specter or spectre, spirit, spook, and wraith.","https://upload.wikimedia.org/wikipedia/en/thumb/0/02/Hammersmith_Ghost.PNG/220px-Hammersmith_Ghost.PNG");
//        Beast b3 = new Beast(3,"Lou Carcolh","Lou Carcolh, or the Carcolh, is a mythical beast from French folklore. It's described as a large, slimy, snail-like serpent with hairy tentacles and a large shell. It is said to live in a cavern beneath Hastingues, a town in the Les Landes region in southwestern France.[1]\n" +
//                "\n" +
//                "The carcolh's slime could sometimes be seen long before the creature itself arrived. Nobody dared to approach the creature, as unwary persons would be grabbed by its tentacles, dragged into its cave and devoured whole.","https://static.wikia.nocookie.net/cryptidz/images/9/9e/Lou_Carcolh.jpg/revision/latest/scale-to-width-down/340?cb=20131009110654");
//        Beast b4 = new Beast(4,"Chupacabra","Eyewitness sightings have been claimed in Puerto Rico, and have since been reported as far north as Maine, as far south as Chile, and even outside the Americas in countries like Russia and the Philippines. Many of the reports have been disregarded as uncorroborated or lacking evidence. Sightings in northern Mexico and the southern United States have been verified as canids afflicted by mange. According to biologists and wildlife management officials, the chupacabra is an urban legend.","https://upload.wikimedia.org/wikipedia/commons/d/da/Chupacabra_%28artist%27s_rendition%29.jpg");
//        Beast b5 = new Beast(5,"Kraken","The kraken (/ˈkrɑːkən/)[1] is a legendary sea monster of gigantic size and cephalopod-like appearance in Scandinavian folklore. According to the Norse sagas, the kraken dwells off the coasts of Norway and Greenland and terrorizes nearby sailors. Authors over the years have postulated that the legend may have originated from sightings of giant squids that may grow to 13–15 meters (40–50 feet) in length. The sheer size and fearsome appearance attributed to the kraken have made it a common ocean-dwelling monster in various fictional works. The kraken has been the focus of many sailors passing the North Atlantic and especially sailors from the Nordic countries. Throughout the centuries, the kraken has been a staple of sailors' superstitions and mythos.\n" +
//                "\n","https://upload.wikimedia.org/wikipedia/commons/9/9d/Colossal_octopus_by_Pierre_Denys_de_Montfort.jpg");
//        Beast b6 = new Beast(6,"???","Whatever this thing is","https://i2-prod.mirror.co.uk/incoming/article3988894.ece/ALTERNATES/s1200b/Fish-smokes-a-cigarette.png");
        //Beast b7 = new Beast(7,"The Bigfoot","Bigfoot, also known as Sasquatch, in Canadian folklore and American folklore, is an ape-like creature that is purported to inhabit the forests of North America. Supposed evidence of Bigfoot's existence is based on a number of disputed video recordings, audio recordings, photographs, visual sightings, casts of large footprints, etc. Some of these are speculated or known to be hoaxes.\n" +
         //       "\n" +
          //      "Folklorists trace the figure of Bigfoot to a combination of factors and sources, including folklore surrounding the European wild man figure, folk belief among Native Americans and loggers, and a cultural increase in environmental concerns.[2] Within the fringe subculture of cryptozoology Bigfoot is considered a cryptid, but the majority of mainstream scientists have historically discounted the existence of Bigfoot, considering it to be a combination of folklore, misidentification, and hoax, rather than a living animal.[3][4]","https://img.texasmonthly.com/2013/01/bigfoot.jpg");
//        db.addOne(b2);
//        db.addOne(b3);
//        db.addOne(b4);
//        db.addOne(b5);
//        db.addOne(b6);
        //db.addOne(b7);






        beastList = db.getAll();




        recyclerView = findViewById(R.id.rv_beastlist);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecycleViewAdapter(beastList,Bestiary.this);
        recyclerView.setAdapter(adapter);



    }





}