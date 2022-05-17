<?php

$asal='399';
$tujuan='444';
$berat='3750';
$kurir='jne';

$curl = curl_init();

curl_setopt_array($curl, array(
  CURLOPT_URL => "https://api.rajaongkir.com/starter/cost",
  CURLOPT_RETURNTRANSFER => true,
  CURLOPT_ENCODING => "",
  CURLOPT_MAXREDIRS => 10,
  CURLOPT_TIMEOUT => 30,
  CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
  CURLOPT_CUSTOMREQUEST => "POST",
  CURLOPT_POSTFIELDS => "origin=$asal&destination=$tujuan&weight=$berat&courier=$kurir",
  CURLOPT_HTTPHEADER => array(
    "content-type: application/x-www-form-urlencoded",
    "key: 373ebedc2d06eac0e6607f9040af6a50"
  ),
));

$response = curl_exec($curl);
$err = curl_error($curl);

curl_close($curl);

$data=json_decode($response, true);

echo "Kota Asal: ".$data['rajaongkir']['origin_details']['city_name']."<br>";
echo "Kota Tujuan: ".$data['rajaongkir']['destination_details']['city_name']."<br>";
echo "Kurir: ".$data['rajaongkir']['results'][0]['name']."<br>";
echo "Layanan: ".$data['rajaongkir']['results'][0]['costs'][0]['service']."<br>";
echo "Biaya: Rp.".$data['rajaongkir']['results'][0]['costs'][0]['cost'][0]['value']."<br>";
echo "Estimasi Waktu: ".$data['rajaongkir']['results'][0]['costs'][0]['cost'][0]['etd']." hari<br>";