//package SystemDesignCodes;
//
//import java.util.List;
//import java.util.concurrent.ConcurrentLinkedQueue;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.*;
//
///**
// * Created by hadoop on 28/1/18.
// */
//public class CompletableFuture {
//
//    public static void main(String args[]) {
//
//
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        List<CompletableFuture> futures = new ArrayList<>(); // these are only references to tell you when the request finishes
//        Queue<ServletRsp> results = new ConcurrentLinkedQueue<>(); // this has to be thread-safe
//
//        for (LocalDate date : dates) {
//            ServletReq req = new ServletReq(date);
//            CompletableFuture future = CompletableFuture
//                    .supplyAsync(() -> webservice.send(req), service)
//                    .thenAcceptAsync(results::add);
//            futures.add(future);
//        }
//
//        // wait for all requests to finish
//        CompletableFuture.allOf(collect.toArray(new CompletableFuture[collect.size()])).thenAcceptAsync(ignored -> {
//            //you can also handle the response async.
//    }
//    class ServletRsp{
//
//    }
//
//}
/*
https://blog.krecan.net/2013/12/25/completablefutures-why-to-use-async-methods/
https://www.java-success.com/10-%E2%99%A6-executorservice-vs-forkjoin-future-vs-completablefuture-interview-qa/



BEST
http://kennethjorgensen.com/blog/2016/introduction-to-completablefutures

 */



/*

package com.inmobi.ump.fsm;

import java.util.concurrent.CompletableFuture;

import com.google.inject.Inject;
import com.inmobi.ump.runtimes.RuntimeTask;
import com.inmobi.ump.workers.PhotonAttibutesPopulatorFactory;
import com.inmobi.ump.workers.cpipassthrough.CpiPassthroughWorkerFactory;
import com.inmobi.ump.workers.experiments.TrafficDivisionWorkerFactory;
import com.inmobi.ump.workers.geotargetingworker.GeoResponseHandler;
import com.inmobi.ump.workers.geotargetingworker.GeoTargetingWorkerFactory;
import com.inmobi.ump.workers.photonworker.CoreUserProfileFetcherFactory;
import com.inmobi.ump.workers.photonworker.PhotonInvoker;
import com.inmobi.ump.workers.photonworker.UserCustomProfileFactory;
import com.inmobi.ump.workers.pricingengine.PricingEngineWorkerFactory;
import com.inmobi.ump.workers.pricingengine.PublisherObjectiveWorkerFactory;
import com.inmobi.ump.workers.ruleengine.AdPoolRequestPrepareWorkerFactory;
import com.inmobi.ump.workers.ruleengine.AdPoolsInvocationPrepareFactory;
import com.inmobi.ump.workers.ruleengine.CallOutWorkerFactory;
import com.inmobi.ump.workers.ruleengine.RuleEngineWorkerFactory;
import com.inmobi.ump.workers.segmentdetection.SegmentDetectionWorkerFactory;
import com.inmobi.ump.workers.supplyconstraints.SupplyConstraintsLoader;
import com.inmobi.ump.workers.templateselector.SupplyTemplateSelectorFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__({ @Inject}))
public class Enricher {
    final CoreUserProfileFetcherFactory     coreUserProfileFetcherFactory;
    final PhotonAttibutesPopulatorFactory   photonAttibutesPopulatorFactory;
    final GeoTargetingWorkerFactory         geoTargetingWorkerFactory;
    final SupplyConstraintsLoader           supplyConstraintsLoader;
    final SegmentDetectionWorkerFactory     segmentDetectionWorkerFactory;

    final CpiPassthroughWorkerFactory       cpiPassthroughWorkerFactory;
    final TrafficDivisionWorkerFactory      trafficDivisionWorkerFactory;
    final GeoResponseHandler                geoResponseHandler;
    final PublisherObjectiveWorkerFactory   publisherObjectiveWorkerFactory;
    final PricingEngineWorkerFactory        pricingEngineWorkerFactory;
    final AdPoolRequestPrepareWorkerFactory adPoolRequestPrepareWorkerFactory;
    final RuleEngineWorkerFactory           ruleEngineWorkerFactory;
    final CallOutWorkerFactory              callOutWorkerFactory;
    final SupplyTemplateSelectorFactory     supplyTemplateSelectorFactory;
    final AdPoolsInvocationPrepareFactory   adPoolsInvocationPrepareFactory;
    final UserCustomProfileFactory          userCustomProfileFactory;
    final PhotonInvoker                     photonInvoker;

    public CompletableFuture<Void> work(final RuntimeTask runtimeTask) {
        return photonInvoker.work(runtimeTask).thenCompose(x -> {
            photonAttibutesPopulatorFactory.getWorker().work(runtimeTask);
            return geoTargetingWorkerFactory.enrichGeo(runtimeTask);
        }).thenAccept(y -> {
            supplyConstraintsLoader.updateSupplyConstraints(runtimeTask);
            segmentDetectionWorkerFactory.getWorker().work(runtimeTask);
            trafficDivisionWorkerFactory.getWorker().work(runtimeTask);
            publisherObjectiveWorkerFactory.getWorker().work(runtimeTask);
            cpiPassthroughWorkerFactory.getWorker().work(runtimeTask);
            geoResponseHandler.getWorker().work(runtimeTask);
            pricingEngineWorkerFactory.getWorker().work(runtimeTask);
            adPoolRequestPrepareWorkerFactory.getWorker().work(runtimeTask);
            ruleEngineWorkerFactory.getWorker().work(runtimeTask);
            callOutWorkerFactory.getWorker().work(runtimeTask);
            supplyTemplateSelectorFactory.getWorker().work(runtimeTask);
            adPoolsInvocationPrepareFactory.getWorker().work(runtimeTask);
            log.trace(runtimeTask.getTraceMarker(), "Post enrichment, runtimeTask: {}", runtimeTask);
        });
    }
}





 */
/*
package com.inmobi.ump.workers.geotargetingworker;

import com.inmobi.adserve.entity.InventoryDetail;
import com.inmobi.geoservice.thrift.dto.*;
import com.inmobi.phoenix.entity.Carrier;
import com.inmobi.phoenix.entity.wificarrier.WifiCarrier;
import com.inmobi.phoenix.exception.InitializationException;
import com.inmobi.phoenix.util.PropertiesUtil;
import com.inmobi.types.LocationSource;
import com.inmobi.ump.Utils.WorkerUtils;
import com.inmobi.ump.entity.metrics.RemoteCalls;
import com.inmobi.ump.repository.wificarrier.WifiCarrierRepo;
import com.inmobi.ump.runtimes.LatLongNormaliserTaskOuts;
import com.inmobi.ump.runtimes.RuntimeTask;
import com.inmobi.ump.runtimes.coppa.CoppaComplianceDecider;
import com.inmobi.ump.thrift.ThrottledRpc;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.configuration.Configuration;
import org.slf4j.Marker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class GeoTargetingWorkerFactory {

    private final boolean isGeoTargetingEnabled;
    private final ThrottledRpc<GeoRequest, GeoTargetingDetail> geoServiceClientThrottled;

    public GeoTargetingWorkerFactory(ThrottledRpc<GeoRequest, GeoTargetingDetail> geoThrottledClient,
                                     Configuration config) throws InitializationException {

        this.isGeoTargetingEnabled = Boolean.parseBoolean(PropertiesUtil.getString(config, "isGeoTargetingEnabled", "true"));
        this.geoServiceClientThrottled = geoThrottledClient;
    }

    public CompletableFuture<GeoTargetingDetail> enrichGeo(RuntimeTask rt) {
        return new GeoTargetingWorker().work(rt);
    }

    public static GeoRequest buildRequest(Marker traceMarker, RuntimeTask runtimeTask) {
        GeoRequest geoRequest = new GeoRequest();

        //1: setting LatLong in the GeoRequest
        if(runtimeTask.getLatLongNormaliserTaskOuts().isLatLongPresentInReq()) {
            LatLong latLong = getLatLong(runtimeTask);
            log.trace(traceMarker, "The lat-long information is : {}", latLong);
            geoRequest.setLatLong(latLong);
        } else {
            log.trace(traceMarker, "The request does not contain lat-long");
        }

        //2: setting IPAddressDetail
        IPAddressDetail ipAddressDetail = getIPAddressDetail(runtimeTask);
        log.trace(traceMarker, "The ip-country detail is : {}", ipAddressDetail);
        geoRequest.setIpAddressDetail(ipAddressDetail);

        //3: setting connectedBssid
        if(runtimeTask.isPassBssidToGeoService() && null != runtimeTask.getApBssId()) {
            try {
                geoRequest.setConnectedBssid(Long.valueOf(runtimeTask.getApBssId()));
            } catch (NumberFormatException nfe) {
                log.trace(traceMarker, "The bssid is not a valid long, hence not setting");
            }
        }

        //4: setting visible bssids
        if(runtimeTask.isPassBssidToGeoService() && CollectionUtils.isNotEmpty(runtimeTask.getVisibleApBssIds())) {
            try {
                List<Long> visibleBssids = getVisibleBssids(runtimeTask.getVisibleApBssIds());
                log.trace(traceMarker, "The visible bssids are : {}", visibleBssids);
                geoRequest.setVisibleBssids(visibleBssids);
            } catch (NumberFormatException nfe) {
                log.trace(traceMarker, "The list of visible bssids has invalid longs, hence not setting.");
            }
        } else {
            log.trace(traceMarker, "There are no visible bssids in this request");
        }

        //5: Connected CellTower after sdk-500 release
        CellTower conncetedCt = runtimeTask.getConnectedCellTower();
        if (conncetedCt != null) {
            geoRequest.setConnectedCellTower(conncetedCt);
        }

        //6: VisibleCellTowers To be set after sdk-500 goes out
        if (null != runtimeTask.getVisibleCellTowers()) {
            geoRequest.setVisibleCellTowers(runtimeTask.getVisibleCellTowers());
        }

        //7: setting nId in Geo-Request
        if(null != runtimeTask.getNormalizedUserId()) {
            String nId = runtimeTask.getNormalizedUserId();
            log.trace(traceMarker, "Setting nID : {} in Geo-request", nId);
            geoRequest.setNId(nId);
        }

        //8: setting siteId in geoRequest
        geoRequest.setSiteId(runtimeTask.getSiteId());

        //9: setting requestId in geoRequest
        geoRequest.setRequestId(runtimeTask.getTaskId());

        //10: setting Request Source
        RequestSource requestSource = getRequestSource(runtimeTask);
        log.trace(traceMarker, "Setting requestSource : {} in GeoRequest", requestSource);
        if(null != requestSource) {
            geoRequest.setRequestSource(requestSource);
        }

        //11: setting old cell-tower id
        if(null != runtimeTask.getCsid()) {
            geoRequest.setOldCellTowerId(runtimeTask.getCsid());
        }

        //12: setting handsetId in geo-request
        long handsetId = runtimeTask.getHandsetId();
        log.trace(traceMarker, "Setting handsetId : {} in GeoRequest task", handsetId);
        geoRequest.setHandsetId(handsetId);

        //13: optional i64 requestTimeStamp
        geoRequest.setRequestTimeStamp(runtimeTask.getRequestTimestampMillis());

        //14: optional string udid

        if (runtimeTask.getSelectedUid() != null) {
            geoRequest.setUdid(runtimeTask.getSelectedUid());
        }

        // 15: optional LocationConsentStatus locationConsentStatus
        if (runtimeTask.getLocationConsentStatus() != null) {
            geoRequest.setLocationConsentStatus(runtimeTask.getLocationConsentStatus());
        }

        log.trace(traceMarker, "The request to be sent to geo-service is {}", geoRequest);

        return geoRequest;

    }

    class GeoTargetingWorker  {

        private Marker traceMarker;

        public CompletableFuture<GeoTargetingDetail> work(RuntimeTask runtimeTask) {
            traceMarker = runtimeTask.getTraceMarker();
            WifiCarrierRepo wifiCarrierRepo = runtimeTask.getUmpRepos().getWifiCarrierRepo();

            Carrier carrier = runtimeTask.getCarrier();
            int networkTypeID = getNetworkTypeIDForIP(carrier, wifiCarrierRepo);
            runtimeTask.setNetworkTypeId(networkTypeID);

        /*
         * Geo targeting disabled
         */
//            boolean enabled = isGeoTargetingEnabled && (!runtimeTask.isMiSupply());
//                    if (!enabled) {
//                    log.debug(traceMarker,
//                    "Geo Targeting is not enabled and hence not calling the geo-service " +
//                    "for response. Returning from geoTargetingWorker");
//                    runtimeTask.setLocationSource(LocationSource.NO_TARGETING);
//                    return CompletableFuture.completedFuture(null);
//                    }
//
//                    // PUMP-103
//                    CoppaComplianceDecider coppaComplianceDecider = runtimeTask.getCoppaComplianceDecider();
//                    if (coppaComplianceDecider.isCoppaCompliant()) {
//                    runtimeTask.setLocationSource(LocationSource.NO_TARGETING);
//                    log.debug(traceMarker, "The request is coppa compliant. Disabling geo service call.");
//                    return CompletableFuture.completedFuture(null);
//                    }
//
//                    LocationSource locationSource = LocationSource.NO_TARGETING;
//                    GeoRequest geoRequest = buildRequest(traceMarker, runtimeTask);
//                    log.debug(traceMarker, "Request object for geo service: {}", geoRequest);
//                    CompletableFuture<GeoTargetingDetail> result = geoServiceClientThrottled.execute(geoRequest).handle(
//        (res, ex) -> {
//        if (ex != null) {
//        runtimeTask.getImmaculateContext().markRemoteResponseFailure(RemoteCalls.GEO_ENRICH);
//        }
//        return res;
//        });
//        runtimeTask.setGeoTargetingResponseFuture(result);
//        runtimeTask.setLocationSource(locationSource);
//        return result;
//        }
//
//        /* Query the WIFI repository for the carrier-id and return networkTypeID
//         * which indicates if the ccid is wifi (1) or non-wifi (2). This will be
//         * used by the SegmentDetectionWorker downstream in matching the request
//         * to the segments that exist.
//         */
//public int getNetworkTypeIDForIP(Carrier carrier, WifiCarrierRepo wifiCarrierRepo) {
//
//        int networkTypeID;
//        int carrierId = carrier.getCarrierId();
//
//        WifiCarrier wifiCarrier = wifiCarrierRepo.query(carrierId);
//        if (wifiCarrier != null) {
//        networkTypeID = 1;
//        }
//        else {
//        networkTypeID = 2;
//        }
//
//        return networkTypeID;
//        }
//
//        }
//
//static LatLong getLatLong(RuntimeTask runtimeTask) {
//        LatLong latLong = new LatLong();
//        LatLongNormaliserTaskOuts taskOuts = runtimeTask.getLatLongNormaliserTaskOuts();
//        latLong.setLatitude(taskOuts.getRequestLatitude());
//        latLong.setLongitude(taskOuts.getRequestLongitude());
//
//        if(taskOuts.isLatLongAccuracyPresentInReq()) {
//        latLong.setAccuracy(taskOuts.getRequestLatLongAccuracy());
//        }
//
//        if(runtimeTask.getLatLongIsSdkCollected() != null) {
//        latLong.setSdkCollected(runtimeTask.getLatLongIsSdkCollected());
//        }
//
//        if(runtimeTask.getLatLonglastSeenTimeStamp() != null) {
//        latLong.setLastSeenTimeStamp(runtimeTask.getLatLonglastSeenTimeStamp());
//        }
//
//        return latLong;
//        }
//
//static IPAddressDetail getIPAddressDetail(RuntimeTask runtimeTask) {
//        IPAddressDetail ipAddressDetail = new IPAddressDetail();
//
//        Carrier carrier = runtimeTask.getCarrier();
//        ipAddressDetail.setCountryId(carrier.getCountryId());
//
//        String ipString = runtimeTask.getNormalizedRemoteIp();
//        long ipLong = WorkerUtils.ipv4ToLong(ipString);
//        ipAddressDetail.setIpAddress(ipLong);
//
//        return ipAddressDetail;
//        }
//
//static List<Long> getVisibleBssids(List<String> rawBssids) {
//        List<String> relevantBssids = rawBssids.subList(0, Math.min(4, rawBssids.size()));
//        List<Long> bssidLong = new ArrayList<>(relevantBssids.size());
//        for (String bssid : relevantBssids) {
//        bssidLong.add(Long.parseLong(bssid));
//        }
//        return bssidLong;
//        }
//
//static RequestSource getRequestSource(RuntimeTask runtimeTask) {
//        InventoryDetail inventory = runtimeTask.getInventoryDetail();
//        return getRequestSourceFromInventory(runtimeTask.getTraceMarker(), inventory);
//        }
//
//static RequestSource getRequestSourceFromInventory(Marker marker, InventoryDetail detail) {
//        if(null == detail) {
//        log.trace(marker, "The inventory detail is null, returning null");
//        return null;
//        }
//        RequestSource requestSource = new RequestSource();
//        requestSource.setIntegrationMethod(transformToGeo(detail.getIntegrationType().getMethod()));
//        requestSource.setVersion(String.valueOf(detail.getIntegrationVersion()));
//        return requestSource;
//        }
//
//static IntegrationMethod transformToGeo(com.inmobi.types.adserving.IntegrationMethod integrationMethod) {
//        switch(integrationMethod) {
//        case ADCODE:
//        return IntegrationMethod.ADCODE;
//
//        case API:
//        return IntegrationMethod.API;
//
//        case SDK:
//        return IntegrationMethod.SDK;
//
//        case UNKNOWN_METHOD:
//        return IntegrationMethod.UNKNOWN_METHOD;
//
//default:
//        return IntegrationMethod.UNKNOWN_METHOD;
//        }
//        }
//        }
// */

/*

package com.inmobi.ump.thrift;

import lombok.Getter;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

public class ThrottledRpc<In, Out> {
    final Function<In, CompletableFuture<Out>> rpc;
    @Getter
    final ThriftRpcStats stats;
    final Semaphore permits;

    public ThrottledRpc(Function<In, CompletableFuture<Out>> rpc,
                        int maxPermits,
                        ThriftRpcStats stats) {
        this.rpc = rpc;
        this.stats = stats;
        permits = new Semaphore(maxPermits);
    }

    public CompletableFuture<Out> execute(In req) {
        stats.recordAttempts();
        if (permits.tryAcquire()) {
            try {
                return rpc.apply(req).whenComplete((a, ex) -> permits.release());
            } catch (Throwable e) {
                permits.release();
                CompletableFuture<Out> ayncCallFailure = new CompletableFuture<>();
                ayncCallFailure.completeExceptionally(new IOException("Exception encountered while trying async call."));
                return ayncCallFailure;
            }
        } else {
            stats.recordSkips();
            // Returning skips as exception only for accounting in immaculate :: otherwise measured as skips count metrics
            CompletableFuture<Out> skipFailures = new CompletableFuture<>();
            skipFailures.completeExceptionally(new IOException("Unable to acquire semaphore..Max Concurrent call limit reached."));
            return skipFailures;
        }
    }

    /**
     * This method will complete by eating up any exceptions that occur and
     * propagate a null result.
     * <p> If you need the exceptions propagated, use {@link #execute(Object)}
     * @param req
     * @return
//     */
//public CompletableFuture<Out> executeConcealingExceptions(In req) {
//        return execute(req).handle((res, error) -> res);
//        }
//        }
// */