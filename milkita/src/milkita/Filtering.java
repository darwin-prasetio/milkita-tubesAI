package milkita;
public class Filtering{

public static String Filter(String s){
		String hasil;
		hasil = s.toLowerCase();	
		//Syarat filternya. Ini baru ngambil , . ? " / (pake regex)
		//todo, ngambil kata-kata gak pentingnya
		hasil = hasil.replaceAll("[,|\\.|\\?|\"|/]", " ");
		
		//ngambil angka? kayaknya gak penting deh
		hasil = hasil.replaceAll("\\d"," ");
		
		//ngambil kata hubung, ini kata hubung yang ada di jelasin di wikipedia
		hasil = hasil.replaceAll(" yang | agar | supaya | biar | jika | kalau | jikalau | asal | asalkan | bila | manakala | sejak | semenjak | sedari | sewaktu | tatkala | ketika | sementara | begitu | seraya | selagi | selama | serta | sambil | demi | setelah | sesudah | sebelum | sehabis | selesai | seusai | hingga | sampai | andaikan | seandainya | umpamanya | sekiranya | biar | biarpun | walau | walaupun | sekali | sekalipun | sungguhpun | kendati | kendatipun | seakan-akan | seolah-olah | seakan | seolah | sebagaimana | seperti | sebagai | laksana | ibarat | daripada | alih-alih | sebab | karena | oleh | sehingga | sampai | maka | dengan | tanpa | bahwa ", " ");
		
		//ngambil bulan, kayaknya gak penting juga
		hasil = hasil.replaceAll(" januari | februari | pebruari | maret | april | mei | juni | juli | agustus | september | oktober | november | nopember | desember "," ");
		
		//ngambil kata-gak-penting, tapi gatau masuk kategori apa
		hasil = hasil.replaceAll(" dari | dan | pada | untuk ", " ");
		//ngambil kata hubung (gak penting kan?)
		
		//ngambil tanda hubung yang berdiri sendiri (laba-laba) sama (laba) kan beda
		hasil = hasil.replaceAll(" - "," ");
		
		//ngehilangnin multiple white space jadi satu aja
		hasil = hasil.replaceAll("\\s+", " ");
		return hasil;
	}

}