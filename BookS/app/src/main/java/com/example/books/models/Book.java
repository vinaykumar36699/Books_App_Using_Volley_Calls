package com.example.books.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@Entity(tableName = "books_table")
public class Book implements Serializable {
    @NonNull
    @PrimaryKey
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("api_model")
    @Expose
    private String apiModel;
    @SerializedName("api_link")
    @Expose
    private String apiLink;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("main_reference_number")
    @Expose
    private String mainReferenceNumber;
    @SerializedName("has_not_been_viewed_much")
    @Expose
    private Boolean hasNotBeenViewedMuch;
    @SerializedName("date_display")
    @Expose
    private String dateDisplay;
    @SerializedName("artist_display")
    @Expose
    private String artistDisplay;
    @SerializedName("place_of_origin")
    @Expose
    private String placeOfOrigin;
    @SerializedName("medium_display")
    @Expose
    private String mediumDisplay;
    @SerializedName("inscriptions")
    @Expose
    private String inscriptions;
    @SerializedName("credit_line")
    @Expose
    private String creditLine;
    @SerializedName("provenance_text")
    @Expose
    private String provenanceText;
    @SerializedName("publishing_verification_level")
    @Expose
    private String publishingVerificationLevel;
    @SerializedName("internal_department_id")
    @Expose
    private Long internalDepartmentId;
    @SerializedName("fiscal_year")
    @Expose
    private Long fiscalYear;
    @SerializedName("is_public_domain")
    @Expose
    private Boolean isPublicDomain;
    @SerializedName("is_zoomable")
    @Expose
    private Boolean isZoomable;
    @SerializedName("max_zoom_window_size")
    @Expose
    private Long maxZoomWindowSize;
    @SerializedName("has_multimedia_resources")
    @Expose
    private Boolean hasMultimediaResources;
    @SerializedName("has_educational_resources")
    @Expose
    private Boolean hasEducationalResources;
    @SerializedName("is_on_view")
    @Expose
    private Boolean isOnView;
    @SerializedName("on_loan_display")
    @Expose
    private String onLoanDisplay;
    @SerializedName("department_title")
    @Expose
    private String departmentTitle;
    @SerializedName("artist_id")
    @Expose
    private Long artistId;
    @SerializedName("artist_title")
    @Expose
    private String artistTitle;
    @SerializedName("last_updated")
    @Expose
    private String lastUpdated;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    private final static long serialVersionUID = -1525332075066518033L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApiModel() {
        return apiModel;
    }

    public void setApiModel(String apiModel) {
        this.apiModel = apiModel;
    }

    public String getApiLink() {
        return apiLink;
    }

    public void setApiLink(String apiLink) {
        this.apiLink = apiLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainReferenceNumber() {
        return mainReferenceNumber;
    }

    public void setMainReferenceNumber(String mainReferenceNumber) {
        this.mainReferenceNumber = mainReferenceNumber;
    }

    public Boolean getHasNotBeenViewedMuch() {
        return hasNotBeenViewedMuch;
    }

    public void setHasNotBeenViewedMuch(Boolean hasNotBeenViewedMuch) {
        this.hasNotBeenViewedMuch = hasNotBeenViewedMuch;
    }

    public String getDateDisplay() {
        return dateDisplay;
    }

    public void setDateDisplay(String dateDisplay) {
        this.dateDisplay = dateDisplay;
    }

    public String getArtistDisplay() {
        return artistDisplay;
    }

    public void setArtistDisplay(String artistDisplay) {
        this.artistDisplay = artistDisplay;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getMediumDisplay() {
        return mediumDisplay;
    }

    public void setMediumDisplay(String mediumDisplay) {
        this.mediumDisplay = mediumDisplay;
    }

    public String getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(String inscriptions) {
        this.inscriptions = inscriptions;
    }

    public String getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(String creditLine) {
        this.creditLine = creditLine;
    }

    public String getProvenanceText() {
        return provenanceText;
    }

    public void setProvenanceText(String provenanceText) {
        this.provenanceText = provenanceText;
    }

    public String getPublishingVerificationLevel() {
        return publishingVerificationLevel;
    }

    public void setPublishingVerificationLevel(String publishingVerificationLevel) {
        this.publishingVerificationLevel = publishingVerificationLevel;
    }

    public Long getInternalDepartmentId() {
        return internalDepartmentId;
    }

    public void setInternalDepartmentId(Long internalDepartmentId) {
        this.internalDepartmentId = internalDepartmentId;
    }

    public Long getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(Long fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public Boolean getIsPublicDomain() {
        return isPublicDomain;
    }

    public void setIsPublicDomain(Boolean isPublicDomain) {
        this.isPublicDomain = isPublicDomain;
    }

    public Boolean getIsZoomable() {
        return isZoomable;
    }

    public void setIsZoomable(Boolean isZoomable) {
        this.isZoomable = isZoomable;
    }

    public Long getMaxZoomWindowSize() {
        return maxZoomWindowSize;
    }

    public void setMaxZoomWindowSize(Long maxZoomWindowSize) {
        this.maxZoomWindowSize = maxZoomWindowSize;
    }

    public Boolean getHasMultimediaResources() {
        return hasMultimediaResources;
    }

    public void setHasMultimediaResources(Boolean hasMultimediaResources) {
        this.hasMultimediaResources = hasMultimediaResources;
    }

    public Boolean getHasEducationalResources() {
        return hasEducationalResources;
    }

    public void setHasEducationalResources(Boolean hasEducationalResources) {
        this.hasEducationalResources = hasEducationalResources;
    }

    public Boolean getIsOnView() {
        return isOnView;
    }

    public void setIsOnView(Boolean isOnView) {
        this.isOnView = isOnView;
    }

    public String getOnLoanDisplay() {
        return onLoanDisplay;
    }

    public void setOnLoanDisplay(String onLoanDisplay) {
        this.onLoanDisplay = onLoanDisplay;
    }

    public String getDepartmentTitle() {
        return departmentTitle;
    }

    public void setDepartmentTitle(String departmentTitle) {
        this.departmentTitle = departmentTitle;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public String getArtistTitle() {
        return artistTitle;
    }

    public void setArtistTitle(String artistTitle) {
        this.artistTitle = artistTitle;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
