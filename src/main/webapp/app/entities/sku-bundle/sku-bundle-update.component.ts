import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiAlertService } from 'ng-jhipster';
import { ISkuBundle } from 'app/shared/model/sku-bundle.model';
import { SkuBundleService } from './sku-bundle.service';
import { ISkuList } from 'app/shared/model/sku-list.model';
import { SkuListService } from 'app/entities/sku-list';

@Component({
    selector: 'jhi-sku-bundle-update',
    templateUrl: './sku-bundle-update.component.html'
})
export class SkuBundleUpdateComponent implements OnInit {
    skuBundle: ISkuBundle;
    isSaving: boolean;

    skulists: ISkuList[];

    constructor(
        protected jhiAlertService: JhiAlertService,
        protected skuBundleService: SkuBundleService,
        protected skuListService: SkuListService,
        protected activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ skuBundle }) => {
            this.skuBundle = skuBundle;
        });
        this.skuListService
            .query()
            .pipe(
                filter((mayBeOk: HttpResponse<ISkuList[]>) => mayBeOk.ok),
                map((response: HttpResponse<ISkuList[]>) => response.body)
            )
            .subscribe((res: ISkuList[]) => (this.skulists = res), (res: HttpErrorResponse) => this.onError(res.message));
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.skuBundle.id !== undefined) {
            this.subscribeToSaveResponse(this.skuBundleService.update(this.skuBundle));
        } else {
            this.subscribeToSaveResponse(this.skuBundleService.create(this.skuBundle));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<ISkuBundle>>) {
        result.subscribe((res: HttpResponse<ISkuBundle>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError() {
        this.isSaving = false;
    }

    protected onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    trackSkuListById(index: number, item: ISkuList) {
        return item.id;
    }
}
