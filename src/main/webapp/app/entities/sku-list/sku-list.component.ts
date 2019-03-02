import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { ISkuList } from 'app/shared/model/sku-list.model';
import { AccountService } from 'app/core';
import { SkuListService } from './sku-list.service';

@Component({
    selector: 'jhi-sku-list',
    templateUrl: './sku-list.component.html'
})
export class SkuListComponent implements OnInit, OnDestroy {
    skuLists: ISkuList[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        protected skuListService: SkuListService,
        protected jhiAlertService: JhiAlertService,
        protected eventManager: JhiEventManager,
        protected accountService: AccountService
    ) {}

    loadAll() {
        this.skuListService
            .query()
            .pipe(
                filter((res: HttpResponse<ISkuList[]>) => res.ok),
                map((res: HttpResponse<ISkuList[]>) => res.body)
            )
            .subscribe(
                (res: ISkuList[]) => {
                    this.skuLists = res;
                },
                (res: HttpErrorResponse) => this.onError(res.message)
            );
    }

    ngOnInit() {
        this.loadAll();
        this.accountService.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInSkuLists();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: ISkuList) {
        return item.id;
    }

    registerChangeInSkuLists() {
        this.eventSubscriber = this.eventManager.subscribe('skuListListModification', response => this.loadAll());
    }

    protected onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
