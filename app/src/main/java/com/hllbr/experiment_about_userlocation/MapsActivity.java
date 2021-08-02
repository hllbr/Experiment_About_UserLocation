package com.hllbr.experiment_about_userlocation;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hllbr.experiment_about_userlocation.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //LocationManager = konum yöneticisi demektir.
        //we needed casiton concept
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);//bu alada getSharedPreferences da kullanılabilir fakat güncel servislerle çalışmak daha mantıklı bir yöntem olduğu için getSystemServices kullanmak mantıklı bir durum alıyor.
        //Konum değişikliklerini algılamadan bu durumlarla ilgili işlemler gerçekleştiremeyiz bu sebeple konum değşikliklerini dinleyen bir yapı ihtiyacımız var buda locationlİSTENER olarak ifade edilen konum dğeşikliklerini izleyen ve haber veren bir yapı bulunmakta bu yapıdan faydalanarak işlemlerimizi ilerletebiliriz.

        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                //Arayüzlerden obje oluşturulmadığı için override metod ile üzerinde çalışmalarımızı yürütüyoruz
                //bu yapı içerisinde enlem ve boylam dışında yükseklikte alabiliriz.
                System.out.println(location.getAltitude() +" yükseklik :)");
                System.out.println("Location : " +location.toString());

            }
            //locationListener içerisinde üzerine yazabileceğimiz başka metodlarda bulunmakta

            @Override
            public void onProviderDisabled(@NonNull String provider) {
                //konum sağlayıcımız neyse etkin halden çıkartıldığnda birşey yapmak istiyor muyuz ...

            }

            @Override
            public void onProviderEnabled(@NonNull String provider) {
                //konum sağlayıcısı etkinken birşey yapmak istiyor muyuz ?

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                //Kaldırıldı eski sürümlerde var güncel versiyonda kullanılmasını GOOGLE istemiyor.
                //Genel olarak durumda değişiklik oldu birşey yapamk istiyor muyuz .
                //Bazı sürümlerde bu yapının çağrılmadığı durumlarda app çöküyordu eğüer app içerisinde sorun yaşıyorsak bu alanı boş bile çağırsak sorun ortadan kalkacaktır.Diyebiliriz.

            }
        };
    }
}