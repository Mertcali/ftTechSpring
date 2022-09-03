# FT Teknoloji Java Spring Practicum

İstenilen Entityler:

### Kullanıcı
* Id
* Adı(50 char)
* Soyadı(50 char)
* Email(50 char)
* telefon(15 char)

### Urun
* Id
* Adı
* Fiyat
* Son Kullanma Tarihi(null olabilir)

### UrunYorum

* Id
* Yorum(500 char)
* yorumTarihi(date)
* urunId
* kullaniciId

*************************************************

Repository içinde; 

* Bir ürüne ait yorumları listeleyen bir metot yazınız.
* Verilen tarih aralıklarında belirli bir ürüne yapılmış olan yorumları gösteren bir metot yazınız. 
* Bir kullanıcının yapmış olduğu yorumları listeleyen bir metot yazınız.
* Bir kullanıcının belirli tarihler aralığında yapmış olduğu yorumları gösteren bir metot yazınız. 
* Son kullanma tarihi geçmiş ürünleri listeleyen bir metot yazınız.
* Son kullanma tarihi geçmemiş ürünleri listeleyen bir metot yazınız. (Son kullanma tarihi boş olanlar da gelmeli.)


*************************************************

Kullanılanlar:

- Jpa
- Lombok
- Database olarak H2 ile InMemory çalışıldı
- Spring Validation
- ModelMapperService kullanılmıştı ancak ProductReview maplemesinde sorun çıktığı için manuel map'e dönüldü.
- Request Response pattern
- Result Pattern
- Exception Handling, Validation Exception Handling
- CRUD İşlemler ve İsterler tamamlandı.
- Swagger üzerinden bütün testler yapıldı.




 
