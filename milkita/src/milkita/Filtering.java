package milkita;
public class Filtering{

public static String Filter(String s){
		String hasil;
		hasil = s.toLowerCase();	
		//Syarat filternya. Ini baru ngambil , . ? " / (pake regex)
		//todo, ngambil kata-kata gak pentingnya
		hasil = hasil.replaceAll("[,|\\.|\\?|\"|/]", " ");
                
                //ngilangin enter
                hasil = hasil.replaceAll("\n"," ");
                
		//ngambil angka? kayaknya gak penting deh
		hasil = hasil.replaceAll("\\d"," ");
		
                //hilangin hari
                hasil = hasil.replaceAll(" senin | selasa | rabu | kamis | jumat | sabtu | minggu "," ");
                
                //kata subjek
                hasil = hasil.replaceAll(" saya | anda | kamu | dia | mereka | kita | kami | aku "," ");
                
		//ngambil kata hubung, ini kata hubung yang ada di jelasin di wikipedia
		hasil = hasil.replaceAll(" tepatnya | di | dilaksanakan | menggunakan | menjadi | tetap | akhirnya |\\s?merupakan\\s? | seharusnya | ternyata | hanya | lainnya | tersebut | yang | agar | supaya | biar | jika | kalau | jikalau | asal | asalkan | bila | manakala | sejak | semenjak | sedari | sewaktu | tatkala | ketika | sementara | begitu | seraya | selagi | selama | serta | sambil | demi | setelah | sesudah | sebelum | sehabis | selesai | seusai | hingga | sampai | andaikan | seandainya | umpamanya | sekiranya | biar | biarpun | walau | walaupun | sekali | sekalipun | sungguhpun | kendati | kendatipun | seakan-akan | seolah-olah | seakan | seolah | sebagaimana | seperti | sebagai | laksana | sedangkan | ibarat | daripada | alih-alih | sebab | karena | oleh | sehingga | sampai | maka | dengan | tanpa | bahwa ", " ");
                
		//ngambil bulan, kayaknya gak penting juga
		hasil = hasil.replaceAll(" besok | kemarin | hari | januari | februari | pebruari | maret | april | mei | juni | juli | agustus | september | oktober | november | nopember | desember "," ");
		
		//ngambil kata-gak-penting, tapi gatau masuk kategori apa
		hasil = hasil.replaceAll(" juga | sudah | adalah | kata | tapi | depan | belakang |\\s?akan\\s? | ini | itu | tak | tidak | dari | dan | pada | untuk "," ");
		//ngambil kata hubung (gak penting kan?)
		
		//ngambil tanda hubung yang berdiri sendiri (laba-laba) sama (laba) kan beda
		hasil = hasil.replaceAll(" - |\\s?--\\s?"," ");
                
                //kata yang menyatakan bilangan dan uang
                hasil = hasil.replaceAll("satu | dua | tiga | empat | lima | enam | tujuh | delapan | sembilan | sepuluh | puluhan |"
                        + " ratusan | ribuan | jutaan | milyar | milyaran | miliar | miliaran | ratus | ribu | rupiah | rp "," ");
                
                hasil = hasil.replaceAll("\\s?republika co id |\\s?metrotvnews com | \\(antara news\\)- |perusahaan | pt | aneka |tempo co "," ");
		
		//ngehilangnin multiple white space jadi satu aja
		hasil = hasil.replaceAll("\\s+", " ");
		return hasil;
	}

}