package com.example.submision;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    private static String[] nama = {
            "Motherboard X570 AORUS ULTRA",
            "Motherboard Z390 AORUS XTREME",
            "Motherboard X570 AORUS PRO WIFI",
            "Motherboard X570 AORUS XTREME",
            "Ram Corsair Dominator Platinum RGB 32GB DDR4-3200MHz",
            "Ram G.Skill Trident Z RGB 16GB DDR4-2400MHz",
            "Ram Ballistix Tactical Tracer RGB 32GB DDR4-2666 MHz",
            "Ram G.Skill Ripjaws V 16GB DDR4-2400MHz",
            "Ram Patriot Viper Elite 8GB DDR4-2400MHz",
            "Vga ASUS GeForce RTX 2080 Ti",
            "Vga EVGA GeForce GTX 1080 Ti",
            "Vga MSI GeForce GTX 1080",
            "Casing Armaggeddon M1X",
            "Casing Armaggeddon M1G",
            "Casing Gaming VenomRX Bravos"
    };
    private static String[] detail = {
            "Klik Untuk Lihat Detail Lebih Lanjut",
            "Klik Untuk Lihat Detail Lebih Lanjut",
            "Klik Untuk Lihat Detail Lebih Lanjut",
            "Klik Untuk Lihat Detail Lebih Lanjut",
            "Klik Untuk Lihat Detail Lebih Lanjut",
            "Klik Untuk Lihat Detail Lebih Lanjut",
            "Klik Untuk Lihat Detail Lebih Lanjut",
            "Klik Untuk Lihat Detail Lebih Lanjut",
            "Klik Untuk Lihat Detail Lebih Lanjut",
            "Klik Untuk Lihat Detail Lebih Lanjut",
            "Klik Untuk Lihat Detail Lebih Lanjut",
            "Klik Untuk Lihat Detail Lebih Lanjut",
            "Klik Untuk Lihat Detail Lebih Lanjut",
            "Klik Untuk Lihat Detail Lebih Lanjut",
            "Klik Untuk Lihat Detail Lebih Lanjut"
    };

    private static String[] data = {
            "Supports AMD 3rd Gen Ryzen™/ 2nd Gen Ryzen™/ 2nd Gen Ryzen™ with Radeon™ Vega Graphics/ Ryzen™ with Radeon™ Vega Graphics Processors. Dual Channel ECC/ Non-ECC Unbuffered DDR4, 4 DIMMs. 12+2 Phases IR Digital VRM Solution with PowIRstage. ",
            "Supports AMD 3rd Gen Ryzen™/ 2nd Gen Ryzen™/ 2nd Gen Ryzen™ with Radeon™ Vega Graphics/ Ryzen™ with Radeon™ Vega Graphics Processors. Dual Channel ECC/ Non-ECC Unbuffered DDR4, 2 DIMMs. Direct 8 Phases IR Digital VRM Solution with PowIRstage",
            "Supports 9th and 8th Gen Intel® Core™ Processors. Dual Channel Non-ECC Unbuffered DDR4, 4 DIMMs. Intel® Optane™ Memory Ready.",
            "Supports AMD 3rd Gen Ryzen™/ 2nd Gen Ryzen™/ 2nd Gen Ryzen™ with Radeon™ Vega Graphics/ Ryzen™ with Radeon™ Vega Graphics Processors. Dual Channel ECC/ Non-ECC Unbuffered DDR4, 4 DIMMs. Direct 16 Phases Infineon Digital VRM Solution with 70A Power Stage",
            "Speed: DDR4-3200MHz | Timing: 16-18-18-36 | Cas Latency: 16 | Voltage: 1.35V | Dimms: 2x16GB",
            "Speed: DDR4-2400MHz | Timing: 15-15-15-35 | Cas Latency: 15 | Voltage: 1.2V | Dimms: 2x8GB",
            "Speed: DDR4-2666MHz | Timing: 16-18-18-36 | Cas Latency: 16 | Voltage: 1.2V | Dimms: 4x8GB",
            "Speed: DDR4-2400MHz | Timing: 15-15-15-35 | Cas Latency: 15 | Voltage: 1.2V | Dimms: 2x8GB",
            "Speed: DDR4-2400MHz | Timing: 15-15-15-35 | Cas Latency: 15 | Voltage: 1.2V | Dimms: 2x4GB",
            "GTX 1080 Ti mampu menangani 4K Ultra Gaming untuk waktu yang lama di 60 FPS tetapi dengan berkembangnya game, GTX 1080 Ti mulai menurun performa nya di 60FPS. Meskipun bukan masalah besar, namun bagi penggila game pasti merasa kurang. Dengan demikianlah di hardirkan RTX 2080 Ti untuk vga yang terbaik untuk gaming.",
            "Dengan cukup melihat spesifikasi GTX 1080Ti bisa dikatakan bahwa GTX 1080Ti menjadi vga card 4K terbaik. Nvidia GeForce GTX 1080 Ti hadir dengan sesuatu yang mengesankan, 3584 CUDA Cores, 224 unit Texture mapping, dan 88 ROP. VRAM yang berukuran 11GB dan tipe yang sama dengan Titan X dari GDDR5X.",
            "Dengan harga 7jt rupiah, merupakan harga yang fantastis untuk bi sa mendapatkan vga card yang menawarkan game QHD dengan @ 60 + FPS dan 4K yang lancar. Namun, jika kamu bahkan ingin memaksimalkan pada 4K, kami sarankan untuk menggunakan GTX 1080 Ti.",
            "Armaggeddon M1X ini juga mendukung motherboard ATX dan juga liquid cooler dengan ukuran hingga 240mm. Tidak hanya itu, casing PC gaming terbaik yang keren ini juga mendukung performa yang lebih baik dengan dilengkapi USB 3.0 support. Bahkan terdapat dust filter yang akan menjaga kebersihan bagian dalam lebih maksimal. Dibanderol seharga 300 ribuan rupiah.",
            "Bagian dalam casing Armaggeddon M1G ini dilengkapi dengan 5 buah kipas yang memiliki diameter 12 cm. Selain itu untuk mendukung aktivitas gaming Anda, casing yang satu ini memiliki USB 3.0 pada front panel. Desainnya tidak perlu ditanya, Armaggeddon M1G ini fokus pada kesan macho yang kuat. Anda harus membayar 325 ribu rupiah jika ingin memilikinya.",
            "Dominasi warna hitam menjadikan casing PC gaming ini terlihat semakin macho dan keren. Selain itu untuk mendukung performa bermain game, VenomRX Bravos juga mendukung mainboard size Micro ATX. Dilengkapi manajemen kabel yang detail sehingga kondisi bagian dalam lebih rapi. Untuk membawa VenomRX Bravos ke rumah, Anda harus membayar 330 ribu rupiah."
    };
    private static int[] imgPoto = {
            R.drawable.mobo,
            R.drawable.mob,
            R.drawable.mo,
            R.drawable.m,
            R.drawable.rami,
            R.drawable.ramii,
            R.drawable.ramiii,
            R.drawable.ramiiii,
            R.drawable.ramiiiii,
            R.drawable.vgaa,
            R.drawable.vgaaa,
            R.drawable.vgaaaa,
            R.drawable.gaming_1,
            R.drawable.gaming_2,
            R.drawable.gaming_3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv_hardware);
        HardwareAdapter hardwareAdapter = new HardwareAdapter();
        listView.setAdapter(hardwareAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), listdata.class);
                intent.putExtra("namaku", nama[position]);
                intent.putExtra("detail", detail[position]);
                intent.putExtra("data", data[position]);
                intent.putExtra("poto", imgPoto[position]);
                intent.putExtra(listdata.EXTRA_TITLE, nama[position]);
                startActivity(intent);
            }
        });



    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.aboutme,menu);
        return true;
    }
    public boolean onOptionsItemSelected (MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.ab_about:
                Intent intent = new Intent(MainActivity.this, AboutMe.class);
                startActivity(intent);
                return true;
                default:
                    return super.onOptionsItemSelected(menuItem);
        }
    }

     class HardwareAdapter extends BaseAdapter {
        @Override
         public int getCount(){
            return nama.length;
        }

         @Override
         public Object getItem(int position){
            return null;
        }

         @Override
         public long getItemId(int position){
            return 0;
        }

         @SuppressLint("ViewHolder")
         @Override
         public View getView(int position, View view, ViewGroup parent){
             view = getLayoutInflater().inflate(R.layout.item_row_hardware, null);

             ImageView imageView = view.findViewById(R.id.img_item_photo);
             TextView tvNama = view.findViewById(R.id.tv_item_name);
             TextView tvDetail = view.findViewById(R.id.tv_item_detail);

             imageView.setImageResource(imgPoto[position]);
             tvNama.setText(nama[position]);
             tvDetail.setText(detail[position]);

             return view;
         }
     }
}
