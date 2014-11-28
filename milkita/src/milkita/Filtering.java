package milkita;
public class Filtering{

public static String Filter(String s){
		String hasil;
		hasil = s.toLowerCase();	
		//Syarat filternya. Ini baru ngambil , .  " / (pake regex)
		//todo, ngambil kata-kata gak pentingnya
		hasil = hasil.replaceAll("[,|\\.|\\|\"|/]", " ");
                
                //ngilangin enter
                hasil = hasil.replaceAll("\n"," ");
                
		//ngambil angka kayaknya gak penting deh
		hasil = hasil.replaceAll("\\d"," ");
		
                //hilangin hari
                hasil = hasil.replaceAll("senin|selasa|rabu|kamis|jumat|sabtu|minggu"," ");
                
                //kata subjek
                hasil = hasil.replaceAll(" saya | anda | kamu | dia | mereka | kita | kami | aku "," ");
                
		//ngambil kata hubung, ini kata hubung yang ada di jelasin di wikipedia
		hasil = hasil.replaceAll(" bersama |\\stepatnya |\\sdi |\\sdilaksanakan |\\smenggunakan |\\smenjadi |\\stetap |\\sakhirnya |\\smerupakan |\\sseharusnya |\\sternyata |\\shanya |\\slainnya |\\stersebut |\\syang |\\sagar |\\ssupaya |\\sbiar |\\sjika |\\skalau |\\sjikalau |\\sasal |\\sasalkan |\\sbila |\\smanakala |\\ssejak |\\ssemenjak |\\ssedari |\\ssewaktu |\\statkala |\\sketika |\\ssementara |\\sbegitu |\\sseraya |\\sselagi |\\sselama |\\sserta |\\ssambil |\\sdemi |\\ssetelah |\\ssesudah |\\ssebelum |\\ssehabis |\\sselesai |\\sseusai |\\shingga |\\ssampai |\\sandaikan |\\sseandainya |\\sumpamanya |\\ssekiranya |\\sbiar |\\sbiarpun |\\swalau |\\swalaupun |\\ssekali |\\ssekalipun |\\ssungguhpun |\\skendati |\\skendatipun |\\sseakan-akan |\\sseolah-olah |\\sseakan |\\sseolah |\\ssebagaimana |\\sseperti |\\ssebagai |\\slaksana |\\ssedangkan |\\sibarat |\\sdaripada |\\salih-alih |\\ssebab |\\skarena |\\soleh |\\ssehingga |\\ssampai |\\smaka  |\\sdengan |\\stanpa |\\sbahwa ", " ");
                
		//ngambil bulan, kayaknya gak penting juga
		hasil = hasil.replaceAll(" besok | kemarin | hari | januari | februari | pebruari | maret | april | mei | juni | juli | agustus | september | oktober | november | nopember | desember "," ");
		
		//ngambil kata-gak-penting, tapi gatau masuk kategori apa
		hasil = hasil.replaceAll(" tetap | berubah | keluar | masuk | semakin | waktu | arah | daerah | barangkali | mungkin | seringkali | bahkan | terhadap | kemudian | atas | bawah | ucapnya | tegasnya | ucapnya | ujarnya | sempat | antara | kerap | sering | sekitar | pukul | jam | samping | sebelah | masih | lagi | menjelaskan | saja | sebab | hanya | tanggal | bisa | kata | ucap | dikutip | guna | jelas | jelasnya | sebelumnya | setelahnya | seusainya | kini | lalu | nanti | bisa | ke | telah | menurut | sebelum | sesudah | belum | sudah | kepada | tadi | ke | sesuai | sebanyak | lebih | namun | selain | yakni | saat | awal | dalam | juga | sudah | adalah | kata | tapi | depan | belakang |\\sakan | ini | itu | tak | tidak | dari | dan | pada | untuk "," ");
       
		//ngambil kata hubung (gak penting kan)
		
		//ngambil tanda hubung yang berdiri sendiri (laba-laba) sama (laba) kan beda
		hasil = hasil.replaceAll(" - |\\s--\\s"," ");
                
                //kata yang menyatakan bilangan dan uang
                hasil = hasil.replaceAll(" nomor | satu | dua | tiga | empat | lima | enam | tujuh | delapan | sembilan | sepuluh | puluhan |"
                        + " ratusan | ribuan | juta | jutaan | milyar | milyaran | miliar | miliaran | ratus | ribu | rupiah | rp "," ");
                
                hasil = hasil.replaceAll("\\srepublika co id |\\smetrotvnews com | \\(antara news\\)- |perusahaan | pt | aneka |tempo co "," ");
		
		//ngehilangnin multiple white space jadi satu aja
		hasil = hasil.replaceAll("\\s+", " ");
		return hasil;
	}

}