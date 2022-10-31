package com.example.propertyfinderapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val titles: MutableList<String> = mutableListOf()
    val descriptions: MutableList<String> = mutableListOf()
    val beds = intArrayOf(3, 2, 1)
    val baths = intArrayOf(2, 2, 1)
    val years = intArrayOf(1978, 2010, 2002)

//    how to populate the populate the image data by arrayList-of
//    here there are three defined property and each properties have their own images
//    so we have [[first group of images],
//                  [2nd group of images],
//                    [3rd group of images]
//                     ]
    val prop_1_img= arrayListOf<Int>()
    val prop_2_img= arrayListOf<Int>()
    val prop_3_img= arrayListOf<Int>()
    val allImagesArray:MutableList<ArrayList<Int>> = mutableListOf()
    fun populateData()
    {
        descriptions.add("Waterfront Acreage & a magnificent home, shop & barn. A rare and fabulous offering! A Rancher style home on a 10.94 acre property. This location could not be better. The ultimate peaceful and quiet area, yet still close to town. Dream shop and barn, fenced, great for horses. One owner. - For more info click Multimedia (20423757)")
        descriptions.add(": 2.98 acre property is within minutes of downtown Merritt and the Coquihalla! Zoned CR1 this fully fenced property has a 44 X 30 garage with pit for the heavy duty mechanic or ? and a 15 X 20 shed/workshop/potential guest cabin/b& b plus a 2 car carport all with metal roofs & siding. The 1296 sq ft home has been FRESHLY PAINTED and a NEW APPLIANCE PACKAGE added. The 2 bedroom, 1 full bath home has had the Electrical Upgrade (Silver Seal) done recently. There is a huge greenhouse style addition (19'7\\\" X 17'10\\\") and the most gorgeous view of the city & mountains beyond. Owner says good producing drilled well approx 150 ft deep & previous subdivision plan on file in Kamloops. 100 amp service in house & 200 amp service for the garage & workshop. With a little TLC you'll be loving your country living with a spectacular view! (21511578)\")")
        descriptions.add(": LOOKING FOR PRIVACY? HERE IT IS! Beautifully landscaped paradise, with massive 338 feet frontage, peaceful and extremely private 3 acres \\\"estate\\\" in Maple Ridge. It is perfect for you and your family to come back to nature. Minutes to Whonnock Elementary, Whonnock Lake and a golf course. Enjoy your own private forest out your front and back door. This fantastic location in the heart of wilderness offers unlimited options and all privacy one could want! Truly a rare find of park-like living. The value is mostly in land with solid, clean mobile home and Large shop plus double carport. (No for sale sign on the property) (22908001)\")")

        titles.add("\$825000")
        titles.add("\$499,900")
        titles.add("\$839,000")

//        add the images data one by one
        prop_1_img.add(R.drawable.property_1_img_1)
        prop_1_img.add(R.drawable.property_1_img_2)
        prop_1_img.add(R.drawable.property_1_img_3)
        allImagesArray.add(prop_1_img)

        prop_2_img.add(R.drawable.property_2_img_1)
        prop_2_img.add(R.drawable.property_2_img_2)
        prop_2_img.add(R.drawable.property_2_img_3)
        prop_2_img.add(R.drawable.property_2_img_4)
        allImagesArray.add(prop_2_img)

        prop_3_img.add(R.drawable.property_3_img_1)
        prop_3_img.add(R.drawable.property_3_img_2)
        allImagesArray.add(prop_3_img)


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val card_1=findViewById<LinearLayout>(R.id.card_1)
        val card_2=findViewById<LinearLayout>(R.id.card_2)
        val card_3=findViewById<LinearLayout>(R.id.card_3)
        val card_1_title_TextView=findViewById<TextView>(R.id.card_1_titleTextView)
        val card_2_title_TextView=findViewById<TextView>(R.id.card_2_tiitle_TextView)
        val card_3_title_TextView=findViewById<TextView>(R.id.card_3_Title_textView)
//        here we have required to add the ViewOnClickListener in this class
//        we have to take the function in our class inheritances
//        then we have to implement the members
        populateData()
//        after populating data
        card_1_title_TextView.text=titles[0]
        card_2_title_TextView.text=titles[1]
        card_3_title_TextView.text=titles[2]
//        from each of the title array we can write in the textview,we can read from the array and populate data into ur UI

        card_1.setOnClickListener(this)
        card_2.setOnClickListener(this)
        card_3.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val intent =Intent(this,DetailsActivity::class.java)
        var index=0
        when(view!!.id){
            R.id.card_1-> index=0
            R.id.card_2->index=1
            R.id.card_3->index=2

        }
//        intent function give command to move from here (this class i.e. main activity) to detailActivity
        val extras=Bundle()
//        how we know which one of the beds would be send?
        extras.putInt("bedsKey",beds[index])
        extras.putInt("bathsKey",baths[index])
        extras.putInt("yearsKey",years[index])
        extras.putString("titlesKey",titles[index])
        extras.putString("bedsKey",descriptions[index])

        extras.putIntegerArrayList("imagesKey",allImagesArray[index])

        intent.putExtras(extras)
        startActivity(intent)
//        now we have to come back part also
//        for that we have to go to detail activity
    }
}