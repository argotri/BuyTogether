import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { ISkuBundle } from 'app/shared/model/sku-bundle.model';
import { AccountService } from 'app/core';
import { SkuBundleService } from './sku-bundle.service';

@Component({
    selector: 'jhi-sku-bundle',
    templateUrl: './sku-bundle.component.html'
})
export class SkuBundleComponent implements OnInit, OnDestroy {
    skuBundles: ISkuBundle[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        protected skuBundleService: SkuBundleService,
        protected jhiAlertService: JhiAlertService,
        protected eventManager: JhiEventManager,
        protected accountService: AccountService
    ) {}

    loadAll() {
        this.skuBundleService
            .query()
            .pipe(
                filter((res: HttpResponse<ISkuBundle[]>) => res.ok),
                map((res: HttpResponse<ISkuBundle[]>) => res.body)
            )
            .subscribe(
                (res: ISkuBundle[]) => {
                    this.skuBundles = res;
                },
                (res: HttpErrorResponse) => this.onError(res.message)
            );
    }

    ngOnInit() {
        this.loadAll();
        this.accountService.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInSkuBundles();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: ISkuBundle) {
        return item.id;
    }

    registerChangeInSkuBundles() {
        this.eventSubscriber = this.eventManager.subscribe('skuBundleListModification', response => this.loadAll());
    }

    protected onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
