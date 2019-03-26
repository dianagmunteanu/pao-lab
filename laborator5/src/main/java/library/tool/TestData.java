package library.tool;

public class TestData {
    private static TestData ourInstance = new TestData();

    private String[] userData = new String[]{
            "1,Bell,Iglesiaz,biglesiaz0@so-net.ne.jp,Female,0ce419e5-4d11-4a8e-9eac-4c0cfa9ffb14",
            "2,Lynsey,Kenyam,lkenyam1@mysql.com,Female,f419d753-3db9-401c-aabc-ba11023c806a",
            "3,Smith,Elcoux,selcoux2@t.co,Male,f83ce4ed-56c7-46f6-8a99-34ca7ccbf878",
            "4,Sherman,Robbey,srobbey3@sfgate.com,Male,0693dd3f-efa4-4303-abf7-9149b98326aa",
            "5,Janeva,Chadney,jchadney4@sciencedirect.com,Female,7a956993-b111-4770-b8f5-f8fc56c70d05",
            "6,Vyky,Breche,vbreche5@psu.edu,Female,b7f4a9f9-adb5-4c8d-aecf-2ccc84bd98c7",
            "7,Ethelin,Alejandre,ealejandre6@rambler.ru,Female,93c61676-150d-45d0-bbcc-997e213b1929",
            "8,Anica,Coghlin,acoghlin7@go.com,Female,9b31c37d-d3f0-4083-af98-775b87727429",
            "9,Alidia,Shirlaw,ashirlaw8@imageshack.us,Female,8adb2e52-ef07-4a4d-bfae-bcaf2fd91cb1",
            "10,Martino,Dun,mdun9@microsoft.com,Male,a2282df8-dfc7-4b96-9753-f29d3c4d8bae",
            "11,Adelaida,Older,aoldera@typepad.com,Female,4c91ac43-ee04-4695-9de4-8ee50c3c3519",
            "12,Aloin,Burgen,aburgenb@feedburner.com,Male,d0c02e1e-1ebc-46e1-8364-4309b00cd9c0",
            "13,Avivah,Cornell,acornellc@java.com,Female,fd0b980a-1b21-45c6-8a59-fe404a9f9cc3",
            "14,Nevins,Straneo,nstraneod@theguardian.com,Male,1a284580-10c8-4194-9758-f6811555404f",
            "15,Yolande,Toft,ytofte@amazon.co.jp,Female,2728eff9-052e-435a-860d-8189e6a83909",
            "16,Nessy,Coad,ncoadf@dell.com,Female,d17f1691-211c-4a85-b8c9-c7b59c6650dc",
            "17,Jodi,Hurley,jhurleyg@utexas.edu,Male,c5dae222-b4d7-4b19-9df9-7f379eb95175",
            "18,Sarajane,Cleland,sclelandh@geocities.jp,Female,a00e29c5-9ee9-4d24-84b6-6794d97dc98b",
            "19,Lezley,De Cruz,ldecruzi@weibo.com,Male,192cea8d-8b8a-4085-954e-d5ed5a65982f",
            "20,Carlyle,Cammocke,ccammockej@indiegogo.com,Male,0b6af916-1afc-409c-a6f5-39138a9dd6ac"
    };

    private String[] movieData = new String[]{
            "1,Ladykillers, The,Comedy|Crime",
            "2,Amish Murder, An,Action|Crime|Drama",
            "3,Legendary,Drama",
            "4,The Great Northfield Minnesota Raid,Action|Western",
            "5,Indochine,Drama|Romance",
            "6,Turning Tide (En solitaire),Adventure|Drama",
            "7,The Wrecking Crew,Documentary",
            "8,If I Stay,Drama",
            "9,Mighty Heart, A,Drama|Thriller",
            "10,Flandres (Flanders),Action|Drama|War",
            "11,American Ninja 3: Blood Hunt,Action|Adventure",
            "12,Cropsey,Documentary|Horror",
            "13,City Hall,Drama|Thriller",
            "14,Cloudburst,Adventure|Comedy|Drama",
            "15,War at Home, The,Drama",
            "16,Another Day, Another Time: Celebrating the Music of Inside Llewyn Davis,Documentary",
            "17,Dirty Harry,Action|Crime|Thriller",
            "18,Lilith,Drama",
            "19,Color of Pomegranates, The (Sayat Nova),Drama",
            "20,Anguish (Angustia),Horror"
    };

    public String[] getUserData() {
        return userData;
    }

    public String[] getMovieData() {
        return movieData;
    }

    public static TestData getInstance() {
        return ourInstance;
    }

    private TestData() {
    }


}
