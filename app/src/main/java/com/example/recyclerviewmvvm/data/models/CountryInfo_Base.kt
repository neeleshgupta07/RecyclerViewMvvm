import com.google.gson.annotations.SerializedName

data class CountryInfo_Base (

	@SerializedName("title") val title : String,
	@SerializedName("rows") val rows : List<Rows>
)